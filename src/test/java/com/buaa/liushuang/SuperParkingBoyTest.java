package com.buaa.liushuang;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:49
 * To change this template use File | Settings | File Templates.
 */
public class SuperParkingBoyTest {
    private ParkingBoy superParkingBoy;
    private List<ParkPlace> parkPlaceList;
    @Before
    public void init_SmartParkingBoy(){
        parkPlaceList = new ArrayList<ParkPlace>();
    }

    @Test
    public void should_smart_park_car_two_park_place_2() throws NoSpaceParkingException {
        ParkPlace parkPlace1 = new ParkPlace(2);
        ParkPlace parkPlace2 = new ParkPlace(3);
        parkPlaceList.add(parkPlace1);
        parkPlaceList.add(parkPlace2);
        parkPlace1.parkCar(new Car());
        parkPlace2.parkCar(new Car());
        parkPlace2.parkCar(new Car());
        superParkingBoy = new ParkingBoy(parkPlaceList,new HighestAvailableRateParkPlaceChooser());

        superParkingBoy.parkCar(new Car());

        Assert.assertEquals(0, parkPlace1.getParkingSpaceNumber());
    }
}
