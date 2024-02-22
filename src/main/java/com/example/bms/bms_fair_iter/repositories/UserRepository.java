package com.example.bms.bms_fair_iter.repositories;

import com.example.bms.bms_fair_iter.models.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE) //  do not run a query (select  *)
    Optional<User> findById(Long aLong);
}
