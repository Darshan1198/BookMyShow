package com.example.bms.bms_fair_iter.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private Date bookingTime;


    @OneToMany(mappedBy = "ticket")
    private List<Payment>  payments;


    //relation between seatsInShow

    //1 ticket  used to book how manyseats in show --> many
    //1 seats can be  used to associate with how many ticket--> one

    @OneToMany(mappedBy = "ticket")
    private  List<SeatInShow>  seats;


    @ManyToOne
    private  User bookedBy;

}
