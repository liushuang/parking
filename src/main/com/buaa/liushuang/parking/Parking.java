package com.buaa.liushuang.parking;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class Parking {
    private int parkingSpaceNumber;
    private Map<String,Car> parkingCarMap = new HashMap<String,Car>();
    
    public Parking(){

    }

    public void parkCar(Car car) throws NoSpaceParkingException{
        if(this.parkingSpaceNumber <= 0){
            throw new NoSpaceParkingException();
        }
        this.parkingCarMap.put(car.getCarId(),car);
        this.parkingSpaceNumber--;
    }

    public void setParkingSpaceNumber(int parkingSpaceNumber) {

       this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public int getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    public Car getCar(Car car) throws NoCarException {
        return getCarByID(car.getCarId());
    }

    public Car getCarByID(String carId) throws NoCarException {
        if(this.parkingCarMap.containsKey(carId)){
            this.parkingSpaceNumber ++;
            Car car = parkingCarMap.get(carId);
            parkingCarMap.remove(carId);
            return car;
        }else{
            throw new NoCarException();
        }
    }
}
