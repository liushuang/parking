package com.buaa.liushuang;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午2:30
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoyTest {
    private ParkingBoy parkingBoy ;
    private ParkPlace parkPlace;
    private List<ParkPlace> parkPlaceList;
    @Before
    public void initParkingBoy(){
    }
    @Test
    public void should_parking_in_a_empty_park_place() throws NoCarException, NoSpaceParkingException {
        parkPlace = new ParkPlace(100);
        parkPlaceList = new ArrayList<ParkPlace>();
        parkPlaceList.add(parkPlace);
        this.parkingBoy = new ParkingBoy(parkPlaceList,new FirstAvailableParkPlaceChooser());
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);
        Assert.assertEquals(99,parkPlace.getParkingSpaceNumber());
        Car carInParkPlace = parkPlace.getCarByTicket(ticket);
        Assert.assertEquals(car,carInParkPlace);
    }

    @Test
    public void should_get_same_car_after_parking() throws NoSpaceParkingException, NoCarException {
        parkPlace = new ParkPlace(100);
        parkPlaceList = new ArrayList<ParkPlace>();
        parkPlaceList.add(parkPlace);
        this.parkingBoy = new ParkingBoy(parkPlaceList,new FirstAvailableParkPlaceChooser());
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);
        Car carAfterParking = parkingBoy.getCarByTicket(ticket);
        Assert.assertEquals(car,carAfterParking);
    }

    @Test
    public void should_park_a_car_when_has_two_park_place() throws NoSpaceParkingException {
        this.parkPlaceList = new ArrayList<ParkPlace>();
        ParkPlace parkPlace1 = new ParkPlace(100);
        ParkPlace parkPlace2 = new ParkPlace(100);
        parkPlaceList.add(parkPlace1);
        parkPlaceList.add(parkPlace2);
        this.parkingBoy = new ParkingBoy(parkPlaceList,new FirstAvailableParkPlaceChooser());
        Car car = new Car();
        parkingBoy.parkCar(car);
        Assert.assertEquals(100-1,parkPlace1.getParkingSpaceNumber() );
    }

    @Test
    public void should_park_a_car_when_has_two_park_place_and_one_is_full() throws NoSpaceParkingException, NoCarException {
        this.parkPlaceList = new ArrayList<ParkPlace>();
        ParkPlace parkPlace1 = new ParkPlace(1);
        ParkPlace parkPlace2 = new ParkPlace(100);
        parkPlaceList.add(parkPlace1);
        parkPlaceList.add(parkPlace2);
        this.parkingBoy = new ParkingBoy(parkPlaceList,new FirstAvailableParkPlaceChooser());
        parkingBoy.parkCar(new Car());
        Car car = new Car();
        Ticket ticket = parkingBoy.parkCar(car);
        Car carAfterParking = parkingBoy.getCarByTicket(ticket);
        Assert.assertSame(car,carAfterParking);
    }

    @Test(expected = NoSpaceParkingException.class)
    public void should_throw_NoSpaceParkingException_when_parking_to_a_full_ParkSpace() throws NoSpaceParkingException {
        this.parkPlaceList = new ArrayList<ParkPlace>();
        ParkPlace parkPlace1 = new ParkPlace(1);
        parkPlaceList.add(parkPlace1);
        this.parkingBoy = new ParkingBoy(parkPlaceList,new FirstAvailableParkPlaceChooser());
        parkingBoy.parkCar(new Car());
        Car car = new Car();
        parkingBoy.parkCar(car);
    }

    @Test(expected = NoSpaceParkingException.class)
    public void should_throw_NoSpaceParkingException_when_parking_to_two_full_ParkSpace() throws NoSpaceParkingException {
        this.parkPlaceList = new ArrayList<ParkPlace>();
        ParkPlace parkPlace1 = new ParkPlace(1);
        ParkPlace parkPlace2 = new ParkPlace(1);
        parkPlaceList.add(parkPlace1);
        parkPlaceList.add(parkPlace2);
        this.parkingBoy = new ParkingBoy(parkPlaceList,new FirstAvailableParkPlaceChooser());
        parkingBoy.parkCar(new Car());
        parkingBoy.parkCar(new Car());
        Car car = new Car();
        parkingBoy.parkCar(car);
    }
}
