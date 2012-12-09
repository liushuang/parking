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
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
public class pringParkingInfoTest {
    private ParkPlace parkPlace1;
    private ParkPlace parkPlace2;
    private ParkPlace parkPlace3;

    private ParkPlace parkingBoy1ParkPlace1;
    private ParkPlace parkingBoy1ParkPlace2;
    private ParkPlace parkingBoy1ParkPlace3;
    private ParkingBoy parkingBoy1;
    private List<ParkPlace> parkingBoy1ParkPlaceList;
    private ParkPlace parkingBoy2ParkPlace1;
    private ParkPlace parkingBoy2ParkPlace2;
    private ParkPlace parkingBoy2ParkPlace3;
    private ParkingBoy parkingBoy2;
    private List<ParkPlace> parkingBoy2ParkPlaceList;

    private ParkPlace parkingManagerParkPlace1;
    private ParkPlace parkingManagerParkPlace2;
    private ParkPlace parkingManagerParkPlace3;
    private List<ParkPlace> parkingManagerParkPlaceList;
    private List<ParkingBoy> parkingManagerParkingBoyList;

    @Before
    public void init(){
        this.parkPlace1 = new ParkPlace(10);

        this.parkingBoy1ParkPlace1  = new ParkPlace(10);
        this.parkingBoy1ParkPlace2  = new ParkPlace(10);
        this.parkingBoy1ParkPlace3  = new ParkPlace(10);
        this.parkingBoy1ParkPlaceList = new ArrayList<ParkPlace>();
        this.parkingBoy1ParkPlaceList.add(parkingBoy1ParkPlace1);
        this.parkingBoy1ParkPlaceList.add(parkingBoy1ParkPlace2);
        this.parkingBoy1ParkPlaceList.add(parkingBoy1ParkPlace3);
        this.parkingBoy1 = new ParkingBoy(parkingBoy1ParkPlaceList,new FirstAvailableParkPlaceChooser());
        this.parkingBoy2ParkPlace1  = new ParkPlace(10);
        this.parkingBoy2ParkPlace2  = new ParkPlace(10);
        this.parkingBoy2ParkPlace3  = new ParkPlace(10);
        this.parkingBoy2ParkPlaceList = new ArrayList<ParkPlace>();
        this.parkingBoy2ParkPlaceList.add(parkingBoy2ParkPlace1);
        this.parkingBoy2ParkPlaceList.add(parkingBoy2ParkPlace2);
        this.parkingBoy2ParkPlaceList.add(parkingBoy2ParkPlace3);
        this.parkingBoy2 = new ParkingBoy(parkingBoy2ParkPlaceList,new FirstAvailableParkPlaceChooser());

        this.parkingManagerParkPlace1 = new ParkPlace(10);
        this.parkingManagerParkPlace2 = new ParkPlace(10);
        this.parkingManagerParkPlace3 = new ParkPlace(10);
        this.parkingBoy2ParkPlaceList = new ArrayList<ParkPlace>();
        this.parkingManagerParkPlaceList = new ArrayList<ParkPlace>();
        this.parkingManagerParkPlaceList.add(parkingManagerParkPlace1);
        this.parkingManagerParkPlaceList.add(parkingManagerParkPlace2);
        this.parkingManagerParkPlaceList.add(parkingManagerParkPlace3);
        this.parkingManagerParkingBoyList = new ArrayList<ParkingBoy>();
        this.parkingManagerParkingBoyList.add(parkingBoy1);
        this.parkingManagerParkingBoyList.add(parkingBoy2);
    }

    @Test
    public void should_return_park_place_info() throws NoSpaceParkingException {
        this.parkPlace1.parkCar(new Car());
        this.parkPlace1.parkCar(new Car());

        String info = parkPlace1.getParkingInfo(0);

        Assert.assertEquals(info,"车位数:10\n空位数:8\n");
        parkPlace1.printParkingInfo();
    }



}
