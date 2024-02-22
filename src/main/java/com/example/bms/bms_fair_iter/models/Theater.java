package com.example.bms.bms_fair_iter.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private  String  name;
    private  String  address;
    private  int  maxSeatsBookingAllowed;

    @ManyToOne
    private  City city;

    @OneToMany ( mappedBy = "theater")
    private List<Auditorium> auditorium;  // theater and  Audotorium relationship




}
