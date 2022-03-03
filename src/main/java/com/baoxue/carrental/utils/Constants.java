package com.baoxue.carrental.utils;

public class Constants {

    public static char CAR_IN_STOCK = '0';//The car is at company
    public static char CAR_BOOKED = '1';//booked
    public static char CAR_USING = '1';//picked up, using
    public static char CAR_BAD = '9';//Vehicle abnormal state

    public static char BOOK_WAITING = '0';//Waiting for pick-up
    public static char BOOK_PROCESSING = '1';//The car has been picked up and is being rented
    public static char BOOK_FINISHED = '9';//The car has been returned and the lease is over

}
