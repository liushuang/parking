package com.buaa.liushuang.parking;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-9
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager extends ParkingBoy {
    public ParkingManager(List<ParkPlace> parkPlaceList) {
        super(parkPlaceList,new HighestAvailableRateParkPlaceChooser());
    }
}
