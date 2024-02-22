package com.example.bms.bms_fair_iter.dtos;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
public class BookTicketRequestDTO {

    private List<Long> ShowSeatIds;
    private  Long  userId;
}
