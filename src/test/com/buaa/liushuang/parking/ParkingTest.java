package com.buaa.liushuang.parking;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public class ParkingTest {

    private Parking park;
    private Car car;

    @Before
    public void init_parking(){
        this.park = new Parking();
        park.setParkingSpaceNumber(100);
        this.car = new Car();
    }

    @Test
    public void should_return_101_after_add_a_car() throws NoSpaceParkingException{
        park.parkCar(car);

        Assert.assertEquals(99,park.getParkingSpaceNumber());
    }

    @Test
    public void should_get_A_car_and_carNumber_minus_1() throws NoSpaceParkingException, NoCarException {
        Car A = new Car();

        int ticket = park.parkCar(A);

        Car B = park.getCarByID(ticket);
        Assert.assertEquals(A,B);
        Assert.assertEquals(100,park.getParkingSpaceNumber());
    }

    @Test(expected = NoSpaceParkingException.class)
    public void should_return_fail_add_car_to_no_space_parking() throws NoSpaceParkingException{
        park.setParkingSpaceNumber(0);

        park.parkCar(car);

    }

    @Test(expected = NoCarException.class)
    public void should_throw_No_Car_Exception_when_get_a_car_from_empty_park() throws NoCarException{
        park.getCarByID(0);
    }

    @Test
    public void should_get_right_car_by_carId() throws NoSpaceParkingException, NoCarException {
        Car car1 = new Car();
        int ticket = park.parkCar(car1);

        Car car2 = park.getCarByID(ticket);

        Assert.assertEquals(car1,car2);
    }

    @Test(expected = NoCarException.class)
    public void should_throw_no_car_exception_get_car_twice_by_carId() throws NoSpaceParkingException, NoCarException {
        int ticket = park.parkCar(car);
        try{
        park.getCarByID(ticket);
        }catch(Exception e){
            Assert.fail("第一次取车就失败啦");
        }
        park.getCarByID(ticket);
    }
}
