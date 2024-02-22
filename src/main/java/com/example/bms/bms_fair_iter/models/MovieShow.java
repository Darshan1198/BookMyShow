package com.example.bms.bms_fair_iter.models;

import com.example.bms.bms_fair_iter.models.enums.Feature;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Getter
@Setter
@Entity
public class MovieShow extends BaseModel {
    private  String  name;
    private Date start;
    private  Date end;


    @ManyToOne
    private  Auditorium auditorium;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature>  requiiredFeature;
}
