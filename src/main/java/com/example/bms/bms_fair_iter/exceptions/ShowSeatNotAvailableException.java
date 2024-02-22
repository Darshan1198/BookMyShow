package com.example.bms.bms_fair_iter.exceptions;

public class ShowSeatNotAvailableException  extends  Exception{
    public  ShowSeatNotAvailableException(){
        super("One of the selected seat is not available ");
    }
}
