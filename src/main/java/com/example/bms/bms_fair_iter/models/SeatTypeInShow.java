package com.example.bms.bms_fair_iter.models;

import com.example.bms.bms_fair_iter.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatTypeInShow  extends BaseModel{
    private  int  price;

    @Enumerated(EnumType.ORDINAL)
    private SeatType  seatType;


    //seattype in a show  associated with 1 show
    // 1 show  will have Many seattype
    @ManyToOne
    private MovieShow show;



}



