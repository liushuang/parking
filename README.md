任务分解

given 一个ParkingManager，管理1个ParkingPlace，最大可以停10辆车
when 向ParkingManager停一辆车
then ParkingPlace的剩余数量为9

given 一个ParkingManager，管理1个ParkingBoy，ParkingBoy管理一个ParkPlace(10)
when 使用ParkingBoy停车
then ParkingBoy管理的ParkPlace数量为9

given 一个ParkingManager，管理一个ParkingPlace，ParkingPlace存有一辆车
when 取车
then 取到同一辆车

----------------ParkingInfo-------------------
given 一个ParkPlace,10个停车位，停了2辆车
when 取停车信息
then 返回"车位数:10\n空位数:8\n"

given 一个ParkingBoy，有管理3个ParkPlace，每个ParkPlace停有2辆车
when 取停车信息
then 返回：
"停车场编号:0\n\t车位数：10\n\t空位数：8\n停车场编号:1\n\t车位数：10\n\t空位数：8\n停车场编号:2\n\t车位数：10\n\t空位数：8\n"

given 一个ParkingManager，管理3个ParkPlace，管理3个ParkingBoy
when 取停车信息
then 返回：
"停车场编号:0\n\t车位数:10\n\t空位数:9\n停车场编号:1\n\t车位数:10\n\t空位数:8\n停车场编号:2\n\t车位数:10\n\t空位数:7\n停车仔编号:0\n\t停车场编号:0\n\t\t车位数:10\n\t\t空位数:8\n\t停车场编号:1\n\t\t车位数:10\n\t\t空位数:8\n\t停车场编号:2\n\t\t车位数:10\n\t\t空位数:8\n\tTotal车位数:30\n\tTotal空位数:24\n停车仔编号:1\n\t停车场编号:0\n\t\t车位数:10\n\t\t空位数:8\n\t停车场编号:1\n\t\t车位数:10\n\t\t空位数:8\n\t停车场编号:2\n\t\t车位数:10\n\t\t空位数:8\n\tTotal车位数:30\n\tTotal空位数:24\nTotal车位数:90\nTotal空位数:72\n"

parking
=======
停车场实例：https://github.com/xianjing/l1-parkingLots.git

http://weibo.com/u/3019412955

www.gradle.org
停车场系统创建构建脚本
1编译
2运行测试产生测试报告
3打包-parkingLotsModel.jar
4与Eclipse/Idea插件集成生成项目文件

gradle idea