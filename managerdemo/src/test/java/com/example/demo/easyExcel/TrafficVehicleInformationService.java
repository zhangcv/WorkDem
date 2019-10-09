package com.example.demo.easyExcel;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Creacted by jack on 2019/12/16 21:00
 **/
public class TrafficVehicleInformationService {
    public String importExcel(List<TrafficVehicleExcelTemplateDto> list) {
        for (TrafficVehicleExcelTemplateDto trafficVehicleExcelTemplateDto : list) {
            System.out.println(JSON.toJSONString(trafficVehicleExcelTemplateDto));
        }
        return list.toString();
    }
    public Result importExcel(){


        return new Result();
    }
}
