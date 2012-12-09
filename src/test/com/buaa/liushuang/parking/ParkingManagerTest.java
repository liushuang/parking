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
    private ParkingManager parkingManager;

    private List<ParkPlace> managerParkPlaceList;
    private ParkPlace managerParkPlace;

    private List<ParkingBoy> parkingBoyList;
    private ParkingBoy parkingBoy;

    private ParkPlace parkingboyParkPlace;
    private List<ParkPlace> parkingBoyParkPlaceList;
    @Before
    public void init(){
        managerParkPlaceList = new ArrayList<ParkPlace>();
        managerParkPlace = new ParkPlace(10);
        managerParkPlaceList.add(managerParkPlace);

        parkingboyParkPlace = new ParkPlace(10);
        parkingBoyParkPlaceList = new ArrayList<ParkPlace>();
        parkingBoyParkPlaceList.add(parkingboyParkPlace);
        parkingBoy = new ParkingBoy(parkingBoyParkPlaceList,new FirstAvailableParkPlaceChooser());
        parkingBoyList = new ArrayList<ParkingBoy>();
        parkingBoyList.add(parkingBoy);
    }

    @Test
    public void should_get_nine_parkingSpaceNum_after_park_to_parkingManager() throws NoSpaceParkingException {
        parkingManager = new ParkingManager(managerParkPlaceList, null);

        parkingManager.parkCar(new Car());

        Assert.assertEquals(managerParkPlace.getParkingSpaceNumber(),9);
    }

    @Test
    public void should_get_nine_after_use_parkingBoy_park() throws NoSpaceParkingException, CanNotFindParkingBoy {
        ParkingManager parkingManager = new ParkingManager(null,parkingBoyList);

        parkingManager.useParkingBoyPark(new Car(),0);

        Assert.assertEquals(parkingboyParkPlace.getParkingSpaceNumber(),9);
    }

    @Test
    public void should_get_same_car_after_parking_to_parkPlace(){

    }
}
