package com.example.bms.bms_fair_iter.models;

import com.example.bms.bms_fair_iter.models.enums.PaymentProvider;
import com.example.bms.bms_fair_iter.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private  int amount;
    private  int transactionId;


    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;


    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;



    //one  payment  is associated with how many ticket -->  1:M
    //one ticket  can  be paid by how many tickets   -->   M

    @ManyToOne
    private Ticket ticket;



}
