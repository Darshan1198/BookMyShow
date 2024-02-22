package com.example.bms.bms_fair_iter.repositories;


import com.example.bms.bms_fair_iter.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Jpa is your ORM   which will writes  querys for you  so we need  our  repository to interface
// And  we have  to say extends  JpaRepository<Ticket(model) ,Long(Ids of Long type)  >
@Repository
public interface  TicketRepository  extends JpaRepository<Ticket, Long> {
    @Override
    Ticket save(Ticket entity);
}
