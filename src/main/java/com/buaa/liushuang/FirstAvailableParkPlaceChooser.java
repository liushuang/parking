package com.buaa.liushuang;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:19
 * To change this template use File | Settings | File Templates.
 */
public class FirstAvailableParkPlaceChooser implements ParkPlaceChooser {
    @Override
    public ParkPlace chooseParkPlace(List<ParkPlace> parkPlaceList) {
        for(int i = 0 ; i < parkPlaceList.size() ; i++){
            if(parkPlaceList.get(i).getParkingSpaceNumber() > 0 )
                return parkPlaceList.get(i);
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
