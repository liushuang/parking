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
    /** 停车场剩余的停车位*/
    private int parkingSpaceNumber;
    /** 停车场所停的车的集合*/
    private Map<Integer,Car> parkingCarMap = new HashMap<Integer,Car>();
    
    public Parking(){

    }

    /**
     * 向停车场中停一辆车
     * @param car 存入的车
     * @return 存车后获得的票据
     * @throws NoSpaceParkingException 没有空余的停车位
     */
    public int parkCar(Car car) throws NoSpaceParkingException{
        if(this.parkingSpaceNumber <= 0){
            throw new NoSpaceParkingException();
        }
        this.parkingCarMap.put(car.hashCode(),car);
        this.parkingSpaceNumber--;
        return car.hashCode();
    }

    /**
     * 设置停车场空余的停车位
     * @param parkingSpaceNumber 停车场空余的停车位
     */
    public void setParkingSpaceNumber(int parkingSpaceNumber) {

       this.parkingSpaceNumber = parkingSpaceNumber;
    }

    /**
     * 获取停车场剩余的停车位
     * @return 停车场剩余的停车位
     */
    public int getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    /**
     * 根据Car的票据返回Car
     * @param carId Car的票据
     * @return 所查找的Car
     * @throws NoCarException 没有找到该Car
     */
    public Car getCarByID(int carId) throws NoCarException {
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
