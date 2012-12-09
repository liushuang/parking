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
}
