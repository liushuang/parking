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
public class ParkingBoy implements ParkingReport {
    protected List<ParkPlace> parkPlaceList = new ArrayList<ParkPlace>();
    private ParkPlaceChooser parkPlaceChooser;

    public ParkingBoy(List<ParkPlace> parkPlaceList , ParkPlaceChooser parkPlaceChooser) {
        this.parkPlaceList = parkPlaceList;
        this.parkPlaceChooser = parkPlaceChooser;
    }

    public Ticket parkCar(Car car) throws NoSpaceParkingException {
        ParkPlace parkPlace = parkPlaceChooser.chooseParkPlace(this.parkPlaceList);
        if(parkPlace == null){
            throw new NoSpaceParkingException();
        }else{
            return parkPlace.parkCar(car);
        }
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

    @Override
    public String getParkingInfo(int level) {
        StringBuilder sb = new StringBuilder();
        int totalParkingSpaceNum = 0;//总空位数
        int totalMaxParkingNum = 0 ;//总车位数
        for(int parkPlaceIndex = 0 ;parkPlaceIndex < this.parkPlaceList.size() ; parkPlaceIndex ++){
            sb.append("停车场编号:" + parkPlaceIndex);
            sb.append("\n");
            sb.append(this.parkPlaceList.get(parkPlaceIndex).getParkingInfo(level+1));
            totalMaxParkingNum += this.parkPlaceList.get(parkPlaceIndex).getMaxParkingNum();
            totalParkingSpaceNum += this.parkPlaceList.get(parkPlaceIndex).getParkingSpaceNumber();
        }
        for(int i = 0 ; i < level ; i++){
            sb.append("\t");
        }
        sb.append("Total车位数:" + getTotalMaxParkingNum() );
        sb.append("\n");
        for(int i = 0 ; i < level ; i++){
            sb.append("\t");
        }
        sb.append("Total空位数:" + getTotalParkingSpaceNum());
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public void printParkingInfo() {
        System.out.println(this.getParkingInfo(0));
    }

    @Override
    public int getTotalMaxParkingNum() {
        int totalMaxParkingNum = 0 ;//总车位数
        for(int parkPlaceIndex = 0 ;parkPlaceIndex < this.parkPlaceList.size() ; parkPlaceIndex ++){
            totalMaxParkingNum += this.parkPlaceList.get(parkPlaceIndex).getTotalMaxParkingNum();
        }
        return totalMaxParkingNum;
    }

    @Override
    public int getTotalParkingSpaceNum() {
        int totalParkingSpaceNum = 0;//总空位数
        for(int parkPlaceIndex = 0 ;parkPlaceIndex < this.parkPlaceList.size() ; parkPlaceIndex ++){
            totalParkingSpaceNum += this.parkPlaceList.get(parkPlaceIndex).getTotalParkingSpaceNum();
        }
        return totalParkingSpaceNum;
    }
}
