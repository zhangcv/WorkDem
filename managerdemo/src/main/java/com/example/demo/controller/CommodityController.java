package com.example.demo.controller;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.Result;
import com.example.demo.function.ResultBean;
import com.example.demo.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Creacted by jack on 2019/9/30 12:44
 **/
@RestController
@RequestMapping("/")
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @PostMapping(value = "com")
    public Result insert(Commodity commodity){
        return ResultBean.success(commodityService.insert(commodity),"插入成功");
    }
    @GetMapping(value="com/{id}")
    public Result findOne(@PathVariable("id") Long id){
        return ResultBean.success(commodityService.findOne(id),"查询单个成功");
    }
    @GetMapping(value = "coms")
    public Result findAll(){
        return ResultBean.success(commodityService.findAll(),"查询所有成功");
    }
    @DeleteMapping(value = "com/{id}")
    public Result delete(@PathVariable Long id){
        return ResultBean.success(commodityService.delete(id),"删除成功");
    }
    @PutMapping(value = "com")
    public Result update(Commodity commodity){
        return ResultBean.success(commodityService.update(commodity),"更新成功");
    }
    @PatchMapping(value = "com")
    public Result updateName(Commodity commodity){
        return ResultBean.success(commodityService.updateName(commodity),"部分更新成功");
    }

    /**
     * 测试类
     */
    @GetMapping("/test")
    public Result<Commodity> selectOne(){
        Commodity commodity = new Commodity();
        commodity.setComId("15");
        commodity.setComName("华为手机");
        commodity.setComPrice("4000");
        commodity.setComDescription("真的很好的一款手机");
        return ResultBean.success(commodity,"success");
    }
}