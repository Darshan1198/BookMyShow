package com.example.bms.bms_fair_iter.controllers;

import com.example.bms.bms_fair_iter.dtos.BookTicketRequestDTO;
import com.example.bms.bms_fair_iter.dtos.BookTicketResponseDto;
import com.example.bms.bms_fair_iter.dtos.ResponseStatus;
import com.example.bms.bms_fair_iter.models.Ticket;
import com.example.bms.bms_fair_iter.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


//controller depends upon services  and  service  depends upon the  repository
@Controller //need not to make  ticket controller object any where
public class TicketController {
    private TicketService ticketService;


    @Autowired  // when ever we reate the  controller  now  it will automaticlly create the  ticket service now
    public  TicketController( TicketService ticketService){
        this.ticketService = ticketService;
    }


    // workflow from available to locked
    public BookTicketResponseDto bookTicket(BookTicketRequestDTO requestDTO){
        BookTicketResponseDto responseDto = new BookTicketResponseDto();


        //never leave a controller  un protected
        try{
            Ticket ticket = ticketService.bookTicket(requestDTO.getShowSeatIds(),requestDTO.getUserId());
            responseDto.setTicketId(ticket.getId());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("Ticket genrated  succesfully");
        }
        catch (Exception ex){
            responseDto.setStatus(ResponseStatus.FAILURE);
            responseDto.setMessage("Something went wrong "+ ex.getMessage());
        }

        return  responseDto;
    }
}
