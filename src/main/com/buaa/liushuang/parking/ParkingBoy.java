package com.buaa.liushuang.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {
    protected List<ParkPlace> parkPlaceList = new ArrayList<ParkPlace>();
    private ParkPlaceChooser parkPlaceChooser;

    public ParkingBoy(List<ParkPlace> parkPlaceList , ParkPlaceChooser parkPlaceChooser) {
        this.parkPlaceList = parkPlaceList;
        this.parkPlaceChooser = parkPlaceChooser;
    }

    public Ticket parkCar(Car car) throws NoSpaceParkingException {
        ParkPlace parkPlace = parkPlaceChooser.chooseParkPlace(this.parkPlaceList);
        if(parkPlace == null){
            throw new NoSpaceParkingException();
        }else{
            return parkPlace.parkCar(car);
        }
    }

    public void addParkPlace(ParkPlace parkPlace) {
        this.parkPlaceList.add(parkPlace);
    }

    public Car getCarByTicket(Ticket ticket) throws NoCarException {
        for(ParkPlace parkPlace : parkPlaceList){
            try{
                return parkPlace.getCarByTicket(ticket);
            }catch (NoCarException e){
                continue;
            }
        }
        throw new NoCarException();
    }
}
