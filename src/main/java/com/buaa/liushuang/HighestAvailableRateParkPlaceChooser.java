package com.buaa.liushuang;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class HighestAvailableRateParkPlaceChooser implements ParkPlaceChooser {
    @Override
    public ParkPlace chooseParkPlace(List<ParkPlace> parkPlaceList) {
        double maxRate = 0 ;
        int maxRatePlaceIndex = 0 ;
        for(int i = 0 ; i < parkPlaceList.size() ; i++){
            if(parkPlaceList.get(i).getParkingSpaceNumber() == 0){
                continue;
            }
            double current = parkPlaceList.get(i).getParkingSpaceNumber() / parkPlaceList.get(i).getMaxParkingNum();
            if( current > maxRate){
                maxRate= current;
                maxRatePlaceIndex = i;
            }
        }
        return parkPlaceList.get(maxRatePlaceIndex);
    }
}
