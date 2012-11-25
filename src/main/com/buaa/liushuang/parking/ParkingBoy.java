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
    private List<ParkPlace> parkPlaceList = new ArrayList<ParkPlace>();

    public ParkingBoy(ParkPlace parkPlace) {
        this.parkPlaceList.add(parkPlace);
    }

    public ParkingBoy(List<ParkPlace> parkPlaceList) {
        this.parkPlaceList = parkPlaceList;
    }

    public Ticket parkCar(Car car) throws NoSpaceParkingException {
        for(int i = 0 ; i < parkPlaceList.size() ; i++){
            if(parkPlaceList.get(i).getParkingSpaceNumber()==0){
                continue;
            }
            else{
                return this.parkPlaceList.get(i).parkCar(car);
            }
        }
        throw new NoSpaceParkingException();
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
