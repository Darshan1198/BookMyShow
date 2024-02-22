package com.example.bms.bms_fair_iter.models;

import com.example.bms.bms_fair_iter.models.enums.Role;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User  extends BaseModel{
    private  String  name;
    private  String  password;
    private  String  username;



    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Role> roles;
}
