package com.example.demo.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Creacted by jack on 2019/9/30 11:39
 **/
@Getter
@Setter
public class Commodity implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String comId;
    @Column
    public String comName;
    @Column
    public String comPrice;
    @Column
    public String comDescription;
}