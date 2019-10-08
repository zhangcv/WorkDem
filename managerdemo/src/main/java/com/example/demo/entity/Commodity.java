package com.example.demo.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Creacted by jack on 2019/9/30 11:39
 **/
@Data
public class Commodity implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String com_id;
    @Column
    public String com_name;
    @Column
    public String com_price;
    @Column
    public String com_description;
}