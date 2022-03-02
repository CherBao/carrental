package com.baoxue.carrental.utils;

public class Constants {

    public static char VEHICLE_IDLE = '0';//车辆空闲状态，可被租用
    public static char VEHICLE_RENTED = '1';//租用中
    public static char VEHICLE_BAD = '9';//车辆异常状态

    public static char BOOK_WAITTING = '0';//已预定，待取车
    public static char BOOK_PROCESSING = '1';//已取车，租用中
    public static char BOOK_FINISHED = '9';//已还车，租用结束

}
