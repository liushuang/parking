package com.buaa.liushuang.parking;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class Parking {
    private int carNumber;
    
    public Parking(){

    }
    
    public void add() {
        this.carNumber++;
    }

    public void setParkingSize(int carNumber) {
       this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }
}
