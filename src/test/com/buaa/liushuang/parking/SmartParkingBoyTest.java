package com.buaa.liushuang.parking;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午4:29
 * To change this template use File | Settings | File Templates.
 */
public class SmartParkingBoyTest {
    private SmartParkingBoy smartParkingBoy;
    private List<ParkPlace> parkPlaceList;
    @Before
    public void init_SmartParkingBoy(){
        parkPlaceList = new ArrayList<ParkPlace>();
    }

    @Test
    public void should_smart_park_car_two_park_place_2() throws NoSpaceParkingException {
        ParkPlace parkPlace1 = new ParkPlace(1);
        ParkPlace parkPlace2 = new ParkPlace(100);
        parkPlaceList.add(parkPlace1);
        parkPlaceList.add(parkPlace2);
        smartParkingBoy = new SmartParkingBoy(parkPlaceList);
        smartParkingBoy.parkCar(new Car());
        Assert.assertEquals(100-1,parkPlace2.getParkingSpaceNumber());
    }
}
