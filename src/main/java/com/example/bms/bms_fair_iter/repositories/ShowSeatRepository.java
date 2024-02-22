package com.example.bms.bms_fair_iter.repositories;


import com.example.bms.bms_fair_iter.models.Seat;
import com.example.bms.bms_fair_iter.models.SeatInShow;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository  extends JpaRepository<SeatInShow, Long> {
    @Override
    SeatInShow save(SeatInShow entity);


    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<SeatInShow> findAllById(Iterable<Long> longs);
}
