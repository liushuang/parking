package com.buaa.liushuang.parking;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-9
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager {
    private List<ParkPlace> parkPlaceList ;
    private ParkPlaceChooser parkPlaceChooser;
    public ParkingManager(List<ParkPlace> parkPlaceList) {
        this.parkPlaceList = parkPlaceList;
        this.parkPlaceChooser = new HighestAvailableRateParkPlaceChooser();
    }

    public Ticket parkCar(Car car) throws NoSpaceParkingException {
        ParkPlace parkPlace = this.parkPlaceChooser.chooseParkPlace(this.parkPlaceList);
        if(parkPlace == null){
            throw new NoSpaceParkingException();
        }else{
            return parkPlace.parkCar(car);
        }
    }
}
