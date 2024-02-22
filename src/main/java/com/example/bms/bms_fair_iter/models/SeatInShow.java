package com.example.bms.bms_fair_iter.models;

import com.example.bms.bms_fair_iter.models.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class SeatInShow extends BaseModel {


    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

    @ManyToOne
    private  Seat seat;

    // one seat  associated  to how many show   1
    // one show can be associated With how many show    :m

    @ManyToOne
    private MovieShow show;

    @ManyToOne
    private Ticket ticket;


    private Date statusUpdatedAt;

}
