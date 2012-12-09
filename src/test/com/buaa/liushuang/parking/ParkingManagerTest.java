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
    public void should_get_one_parkingBoy_after_add_to_parkingManager() throws NoSpaceParkingException {
        List<ParkPlace> parkPlaceList = new ArrayList<ParkPlace>();
        ParkPlace parkPlace = new ParkPlace(10);
        parkPlaceList.add(parkPlace);
        ParkingManager parkingManager = new ParkingManager(parkPlaceList);

        parkingManager.parkCar(new Car());

        Assert.assertEquals(parkPlace.getParkingSpaceNumber(),9);
    }
}
