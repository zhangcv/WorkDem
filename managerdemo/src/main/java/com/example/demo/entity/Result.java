package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 874200365941306385L;

    private Integer code;

    private String msg;

    private T data;


}