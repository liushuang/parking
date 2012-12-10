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
        for(int parkPlaceIndex = 0 ;parkPlaceIndex < this.parkPlaceList.size() ; parkPlaceIndex ++){
            for(int i = 0 ; i < level ; i++){
                sb.append("\t");
            }
            sb.append("停车场编号:" + parkPlaceIndex+ "\n");
            sb.append(this.parkPlaceList.get(parkPlaceIndex).getParkingInfo(level+1));
        }
        for(int parkBoyIndex = 0 ; parkBoyIndex < this.parkingBoyList.size() ; parkBoyIndex++){
            for(int i = 0 ; i < level ; i++){
                sb.append("\t");
            }
            sb.append("停车仔编号:" + parkBoyIndex + "\n");
            sb.append(this.parkingBoyList.get(parkBoyIndex).getParkingInfo(level + 1));
        }
        for(int i = 0 ; i < level ; i++){
            sb.append("\t");
        }
        sb.append("Total车位数:" + this.getTotalMaxParkingNum());
        sb.append("\n");
        for(int i = 0 ; i < level ; i++){
            sb.append("\t");
        }
        sb.append("Total空位数:" + this.getTotalParkingSpaceNum());
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
        for(int parkBoyIndex = 0 ; parkBoyIndex < this.parkingBoyList.size() ;parkBoyIndex ++){
            totalMaxParkingNum += this.parkingBoyList.get(parkBoyIndex).getTotalMaxParkingNum();
        }
        return totalMaxParkingNum;
    }

    @Override
    public int getTotalParkingSpaceNum() {
        int totalParkingSpaceNum = 0;//总空位数
        for(int parkPlaceIndex = 0 ;parkPlaceIndex < this.parkPlaceList.size() ; parkPlaceIndex ++){
            totalParkingSpaceNum += this.parkPlaceList.get(parkPlaceIndex).getTotalParkingSpaceNum();
        }
        for(int parkBoyIndex = 0 ; parkBoyIndex < this.parkingBoyList.size() ;parkBoyIndex ++){
            totalParkingSpaceNum += this.parkingBoyList.get(parkBoyIndex).getTotalParkingSpaceNum();
        }
        return totalParkingSpaceNum;
    }
}
