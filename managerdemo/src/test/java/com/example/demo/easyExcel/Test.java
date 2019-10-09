package com.example.demo.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creacted by jack on 2019/12/16 20:25
 **/
public class Test {


    /**
     *
     */
    @org.junit.Test
    public void test02() {
        EasyExcel.read(getInputStream("D:\\test.xlsx"), TrafficVehicleExcelTemplateDto.class,
                new TrafficVehicleExcelTemplateDtoListener()).sheet(0).headRowNumber(2).doRead();

        System.out.println("ssss");
    }


    /**
     * Filepath 解析List<Object></>
     */
    @org.junit.Test
    public void test01() {
        List<Object> list = EasyExcelFactory.read(getInputStream("D:\\vehicle_import_template (1).xlsx"), new Sheet(1));
        String listString = JSONObject.toJSONString(list);
        System.out.println("list:{}   " + listString);
        JSONArray arryList = JSONObject.parseArray(listString);
        // 处理数据
        List<Map<String, Object>> listMap = new ArrayList<>();
        for (int i = 1; i < arryList.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            JSONArray rowData = JSONObject.parseArray(JSONObject.toJSONString(arryList.get(i)));
            map.put("id", rowData.get(0));
            map.put("name", rowData.get(1));
            map.put("sex", rowData.get(2));
            listMap.add(map);
        }
        System.out.println("data:{}   " + JSONObject.toJSONString(listMap));
    }

    private InputStream getInputStream(String fileName) {
        try {
            return new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

