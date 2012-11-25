package com.buaa.liushuang.parking;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkPlace> parkPlaceList) {
        super(parkPlaceList);
    }

    @Override
    public Ticket parkCar(Car car) throws NoSpaceParkingException {
        int maxSpaceNum = 0;
        int maxSpaceParkPlaceIndex = 0;
        for(int i = 0 ; i < parkPlaceList.size() ; i++){
            if(parkPlaceList.get(i).getParkingSpaceNumber() > maxSpaceNum){
                maxSpaceNum = parkPlaceList.get(i).getParkingSpaceNumber();
                maxSpaceParkPlaceIndex = i;
            }
        }
        return parkPlaceList.get(maxSpaceParkPlaceIndex).parkCar(car);
    }
}
