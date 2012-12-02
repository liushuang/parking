package com.buaa.liushuang.parking;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public class MaxAvailablePlaceParkPlaceChooser implements ParkPlaceChooser {
    @Override
    public ParkPlace chooseParkPlace(List<ParkPlace> parkPlaceList) {
        int maxSpaceNum = 0;
        int maxSpaceParkPlaceIndex = 0;
        for(int i = 0 ; i < parkPlaceList.size() ; i++){
            if(parkPlaceList.get(i).getParkingSpaceNumber() > maxSpaceNum){
                maxSpaceNum = parkPlaceList.get(i).getParkingSpaceNumber();
                maxSpaceParkPlaceIndex = i;
            }
        }
        return parkPlaceList.get(maxSpaceParkPlaceIndex) ;
    }
}
