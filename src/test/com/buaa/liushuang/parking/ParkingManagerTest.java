package com.buaa.liushuang.parking;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-9
 * Time: 下午3:04
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManagerTest {
    @Before
    public void init(){

    }

    @Test
    public void should_get_nine_parkingSpaceNum_after_park_to_parkingManager() throws NoSpaceParkingException {
        List<ParkPlace> parkPlaceList = new ArrayList<ParkPlace>();
        ParkPlace parkPlace = new ParkPlace(10);
        parkPlaceList.add(parkPlace);
        ParkingManager parkingManager = new ParkingManager(parkPlaceList, null);

        parkingManager.parkCar(new Car());

        Assert.assertEquals(parkPlace.getParkingSpaceNumber(),9);
    }

    @Test
    public void should_get_nine_after_use_parkingBoy_park() throws NoSpaceParkingException, CanNotFindParkingBoy {
        ParkPlace parkPlace = new ParkPlace(10);
        List<ParkPlace> parkPlaceList = new ArrayList<ParkPlace>();
        parkPlaceList.add(parkPlace);
        ParkingBoy parkingBoy = new ParkingBoy(parkPlaceList,new FirstAvailableParkPlaceChooser());
        List<ParkingBoy> parkingBoyList = new ArrayList<ParkingBoy>();
        parkingBoyList.add(parkingBoy);
        ParkingManager parkingManager = new ParkingManager(null,parkingBoyList);

        parkingManager.useParkingBoyPark(new Car(),0);

        Assert.assertEquals(parkPlace.getParkingSpaceNumber(),9);

    }
}
