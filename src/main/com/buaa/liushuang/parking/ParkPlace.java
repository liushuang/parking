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
public class ParkPlace {
    /**
     * 停车场剩余的停车位
     */
    private int maxParkingNum;
    /**
     * 停车场所停的车的集合
     */
    private Map<Ticket, Car> parkingCarMap = new HashMap<Ticket, Car>();

    public ParkPlace(int maxParkingNum) {
        this.maxParkingNum = maxParkingNum;
    }

    /**
     * 向停车场中停一辆车
     *
     * @param car 存入的车
     * @return 存车后获得的票据
     * @throws NoSpaceParkingException 没有空余的停车位
     */
    public Ticket parkCar(Car car) throws NoSpaceParkingException {
        if (getParkingSpaceNumber() == 0) {
            throw new NoSpaceParkingException();
        }
        Ticket ticket = new Ticket();
        this.parkingCarMap.put(ticket, car);
        return ticket;
    }

    /**
     * 获取停车场剩余的停车位
     *
     * @return 停车场剩余的停车位
     */
    public int getParkingSpaceNumber() {
        return maxParkingNum - parkingCarMap.size();
    }

    /**
     * 根据Car的票据返回Car
     *
     * @param ticket Car的票据
     * @return 所查找的Car
     * @throws NoCarException 没有找到该Car
     */
    public Car getCarByTicket(Ticket ticket) throws NoCarException {
        if (this.parkingCarMap.containsKey(ticket)) {
            return parkingCarMap.remove(ticket);
        } else {
            throw new NoCarException();
        }
    }
}
