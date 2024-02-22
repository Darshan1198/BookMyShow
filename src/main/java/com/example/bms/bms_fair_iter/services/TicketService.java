package com.example.bms.bms_fair_iter.services;

import com.example.bms.bms_fair_iter.exceptions.ShowSeatNotAvailableException;
import com.example.bms.bms_fair_iter.exceptions.UserNotFoundException;
import com.example.bms.bms_fair_iter.models.SeatInShow;
import com.example.bms.bms_fair_iter.models.SeatTypeInShow;
import com.example.bms.bms_fair_iter.models.Ticket;
import com.example.bms.bms_fair_iter.models.User;
import com.example.bms.bms_fair_iter.models.enums.SeatStatus;
import com.example.bms.bms_fair_iter.repositories.ShowSeatRepository;
import com.example.bms.bms_fair_iter.repositories.TicketRepository;
import com.example.bms.bms_fair_iter.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;

    private TicketRepository ticketRepository;


    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository, UserRepository userRepository, TicketRepository ticketRepository) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)  //isolation  level
    public Ticket  bookTicket  (List<Long> showSeatId, Long userId) throws ShowSeatNotAvailableException,UserNotFoundException{
        //1.get show  seats for  selected  ID's
        //2.check  if they are  available
        //3.if not available send  back with an exception
        //4> Lock them
        // 5. prepare dumy ticket
        // 6. return  ticket

        List<SeatInShow> selectedSeats  = showSeatRepository.findAllById(showSeatId);
        for(SeatInShow seat : selectedSeats){
            if(IsAvailable(seat) == false){
                throw new ShowSeatNotAvailableException();
            }

            // all seats are available

        }
//        User bookedBy  = userRepository.findById(userId);
        Optional<User>  bookedBy = userRepository.findById(userId);
//        if( bookedBy == null)
        if( bookedBy.isEmpty()){
            throw  new UserNotFoundException();

        }

        List<SeatInShow>  selectedUpdatedSeats = new ArrayList<>();
        for( SeatInShow seat: selectedSeats){
            seat.setSeatStatus(SeatStatus.LOCKED);
            seat.setStatusUpdatedAt(new Date());
            seat  = showSeatRepository.save(seat);

            selectedUpdatedSeats.add(seat);

        }

        Ticket ticket = new Ticket();
        ticket.setBookedBy(bookedBy.get());
        ticket.setBookingTime(new Date());
        ticket.setSeats(selectedUpdatedSeats);
        ticket = ticketRepository.save(ticket);

        // also set the amount to be paid in the  ticket  by calling the seattypeInShow Repository
        return  ticket;




    }

    private  boolean IsAvailable(SeatInShow  seat){
        if (seat.getSeatStatus() == SeatStatus.AVAILABLE) return  true;
        else if (seat.getSeatStatus() == SeatStatus.LOCKED){
            Long lockedAt  = seat.getStatusUpdatedAt().getTime();
            Long curerntTime  = System.currentTimeMillis();
            Long  duration  = curerntTime - lockedAt;
            Long durationInSecond = duration/1000;
            Long  durationInMinutes = durationInSecond/60;

            if( durationInMinutes>=10) return true;
        }
        return false;
    }
}
