
package com.example.demo.easyExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;


@Data
public class TrafficVehicleExcelTemplateDto {

    /**
     * value: 表头名称
     * index: 列的号, 0表示第一列
     */
    @ExcelProperty(index = 0)
    private String id;

    @ExcelProperty(index = 1)
    private String driverName;

    @ExcelProperty(index = 2)
    private String plateNumber;

    @ExcelProperty(index = 3)
    private String bracketNumber;
    /**
     * 未知
     */
    @ExcelProperty(index = 4)
    private String frontBrand;

    @ExcelProperty(index = 5)
    private String vehicleType;
    /**
     * 未知
     */
    @ExcelProperty(index = 6)
    private String rearBrand;

    @ExcelProperty(index = 7)
    private String bracketType;
    /**
     * 未知
     */
    @DateTimeFormat("yyyy.MM")
    @ExcelProperty(index = 8)
    private Date vehiclePurchaseTime;
    /**
     * 未知
     */
    @DateTimeFormat("yyyy.MM.dd")
    @ExcelProperty(index = 9)
    private Date firstRuntime;
    /**
     * 未知
     */
    @ExcelProperty(index = 10)
    private String insuranceType;
    /**
     * 未知
     */
    @ExcelProperty(index = 11)
    private String anchorFlag;
    /**
     * 未知
     */
    @ExcelProperty(index = 12)
    private String vehicleMortgageSign;

    @ExcelProperty(index = 13)
    private String note;


}
