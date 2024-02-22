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
public class Seat extends BaseModel {
    private  String  number;
    private  int  row_num;
    private  int col_num;


    @ManyToOne()
    private  Auditorium auditorium;

    @Enumerated(EnumType.ORDINAL)
    private SeatType  seatType;
}
