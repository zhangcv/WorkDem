package com.example.demo.service;

import com.example.demo.entity.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creacted by jack on 2019/9/30 12:45
 **/

public interface CommodityService {

    int insert(Commodity commodity);

    int delete(Long id);

    int update(Commodity commodity);

    int updateName(Commodity commodity);

    Commodity findOne(Long id);

    List<Commodity> findAll();
}