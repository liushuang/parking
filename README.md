����ֽ�

given һ��ParkingManager������1��ParkingPlace��������ͣ10����
when ��ParkingManagerͣһ����
then ParkingPlace��ʣ������Ϊ9

given һ��ParkingManager������1��ParkingBoy��ParkingBoy����һ��ParkPlace(10)
when ʹ��ParkingBoyͣ��
then ParkingBoy�����ParkPlace����Ϊ9

given һ��ParkingManager������һ��ParkingPlace��ParkingPlace����һ����
when ȡ��
then ȡ��ͬһ����

----------------ParkingInfo-------------------
given һ��ParkPlace,10��ͣ��λ��ͣ��2����
when ȡͣ����Ϣ
then ����"��λ��:10\n��λ��:8\n"

given һ��ParkingBoy���й���3��ParkPlace��ÿ��ParkPlaceͣ��2����
when ȡͣ����Ϣ
then ���أ�
"ͣ�������:0\n\t��λ����10\n\t��λ����8\nͣ�������:1\n\t��λ����10\n\t��λ����8\nͣ�������:2\n\t��λ����10\n\t��λ����8\n"

given һ��ParkingManager������3��ParkPlace������3��ParkingBoy
when ȡͣ����Ϣ
then ���أ�
"ͣ�������:0\n\t��λ��:10\n\t��λ��:9\nͣ�������:1\n\t��λ��:10\n\t��λ��:8\nͣ�������:2\n\t��λ��:10\n\t��λ��:7\nͣ���б��:0\n\tͣ�������:0\n\t\t��λ��:10\n\t\t��λ��:8\n\tͣ�������:1\n\t\t��λ��:10\n\t\t��λ��:8\n\tͣ�������:2\n\t\t��λ��:10\n\t\t��λ��:8\n\tTotal��λ��:30\n\tTotal��λ��:24\nͣ���б��:1\n\tͣ�������:0\n\t\t��λ��:10\n\t\t��λ��:8\n\tͣ�������:1\n\t\t��λ��:10\n\t\t��λ��:8\n\tͣ�������:2\n\t\t��λ��:10\n\t\t��λ��:8\n\tTotal��λ��:30\n\tTotal��λ��:24\nTotal��λ��:90\nTotal��λ��:72\n"

parking
=======
ͣ����ʵ����https://github.com/xianjing/l1-parkingLots.git

http://weibo.com/u/3019412955

www.gradle.org
ͣ����ϵͳ���������ű�
1����
2���в��Բ������Ա���
3���-parkingLotsModel.jar
4��Eclipse/Idea�������������Ŀ�ļ�

gradle idea