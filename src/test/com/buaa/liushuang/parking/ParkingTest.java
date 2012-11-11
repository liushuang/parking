package com.buaa.liushuang.parking;

import junit.framework.Assert;
import org.junit.Test;

import javax.smartcardio.Card;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public class ParkingTest {
    @Test
    public void should_return_101_after_add_a_car(){
        Parking park = new Parking()  ;
        park.setParkingSize(100);
        park.add();
        Assert.assertEquals(101,park.getCarNumber());
    }

    @Test
    public void should_get_A_car_and_carNumber_minus_1(){
        Parking park = new Parking();
        park.setParkingSize(100);
        Car A = new Car("10000");
        park.add(A);

        Car B = park.getCar(A);
        Assert.assertEquals(A,B);
        Assert.assertEquals(99,park.getCarNumber());
    }
}
