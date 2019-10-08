package com.example.demo.service.impl;

import com.example.demo.entity.Commodity;
import com.example.demo.mapper.CommodityMapper;
import com.example.demo.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creacted by jack on 2019/9/30 14:28
 **/
@Service
public class CommodityServiceImpl  implements CommodityService {

    @Autowired
    CommodityMapper commodityMapper;

    @Override
    public int insert(Commodity commodity) {

        commodityMapper.insertSelective(commodity);
        int i = Integer.parseInt(commodity.getCom_id());

        return i;
    }

    @Override
    public int delete(Long id) {
        int i = commodityMapper.deleteByPrimaryKey(id);
        System.out.println(i+"备注：1删除成功，0失败");
        return i;
    }

    @Override
    public int update(Commodity commodity) {
        int i = commodityMapper.updateByPrimaryKey(commodity);
        System.out.println(i+"备注：1修改成功，0修改失败");
        return i;
    }

    @Override
    public int updateName(Commodity commodity) {
        int i = commodityMapper.updateByPrimaryKeySelective(commodity);
        System.out.println(i+"备注：1修改成功，0修改失败");
        return i;
    }

    @Override
    public Commodity findOne(Long id) {
        Commodity commodity =new Commodity();
        commodity.setCom_id(id.toString());
        Commodity commodityResult = commodityMapper.selectOne(commodity);
        return commodityResult;
    }

    @Override
    public List<Commodity> findAll() {
        Commodity commodity =new Commodity();
        commodity.setCom_id(null);
        List<Commodity> commodities = commodityMapper.selectAll();
        return commodities;
    }
}