package com.example.demo.mapper;

import com.example.demo.entity.Commodity;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Creacted by jack on 2019/10/8 13:46
 **/

@Component
public interface CommodityMapper extends Mapper<Commodity> {
}
