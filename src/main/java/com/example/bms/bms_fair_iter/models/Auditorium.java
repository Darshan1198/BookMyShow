package com.example.bms.bms_fair_iter.models;


import com.example.bms.bms_fair_iter.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium  extends  BaseModel{
    private  String  name;
    private  int num_rows;
    private  int  num_columns;


    @ManyToOne
    private  Theater theater;

    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;

    @ElementCollection  // with the  list
    @Enumerated(EnumType.ORDINAL)  //only enum
    private  List<Feature> supportedFeatures;


    @OneToMany(mappedBy = "auditorium")
    private List<MovieShow>  shows;


}


