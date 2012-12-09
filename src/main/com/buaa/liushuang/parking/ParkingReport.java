package com.buaa.liushuang.parking;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-9
 * Time: 下午4:11
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingReport {
    /**
     * 格式化的停车场信息
     * @param level 当前层数
     * @return
     */
    public String getParkingInfo(int level);

    /**
     * 打印停车场信息
     */
    public void printParkingInfo();
}
