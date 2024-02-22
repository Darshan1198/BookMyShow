package com.example.bms.bms_fair_iter.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookTicketResponseDto {
    private  Long ticketId;
    private  ResponseStatus status;
    private  String  message;

}
