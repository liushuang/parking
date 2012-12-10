package com.buaa.liushuang;

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
     * @return  格式化的信息
     */
    public String getParkingInfo(int level);

    /**
     * 打印停车场信息
     */
    public void printParkingInfo();

    /**
     * 获取当前所有停车位总数
     * @return  停车位总数
     */
    public int getTotalMaxParkingNum();

    /**
     * 获取当前所有空余停车位总数
     * @return  空车位总数
     */
    public int getTotalParkingSpaceNum();
}
