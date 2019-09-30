package com.example.demo.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * Creacted by jack on 2019/9/30 11:39
 **/
@Data
public class Commodity implements Serializable {


    public String com_id;
    public String com_name;
    public String com_price;
    public String com_description;
}