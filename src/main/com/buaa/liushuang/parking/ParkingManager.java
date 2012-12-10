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
    List<ParkingBoy> parkingBoyList ;
    public ParkingManager(List<ParkPlace> parkPlaceList, List<ParkingBoy> parkingBoyList) {
        super(parkPlaceList,new HighestAvailableRateParkPlaceChooser());
        this.parkingBoyList = parkingBoyList;
    }

    public Ticket useParkingBoyPark(Car car, int parkingBoyIndex) throws NoSpaceParkingException, CanNotFindParkingBoy {
        if(parkingBoyIndex < this.parkingBoyList.size()){
            return this.parkingBoyList.get(parkingBoyIndex).parkCar(car);
        }else{
            throw new CanNotFindParkingBoy();
        }
    }

    @Override
    public Car getCarByTicket(Ticket ticket) throws NoCarException {
        try{
            return super.getCarByTicket(ticket);
        }catch(NoCarException e){
            for(int i = 0 ; i < parkingBoyList.size() ; i++){
                try{
                    return this.parkingBoyList.get(i).getCarByTicket(ticket);
                }catch (NoCarException ex){
                    continue;
                }
            }
            throw new NoCarException();
        }
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
        sb.append("Total车位数:" + totalMaxParkingNum);
        sb.append("\n");
        for(int i = 0 ; i < level ; i++){
            sb.append("\t");
        }
        sb.append("Total空位数:" + totalParkingSpaceNum);
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
