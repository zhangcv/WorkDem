package com.example.demo.easyExcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Creacted by jack on 2019/12/16 16:55
 **/
public class TrafficVehicleExcelTemplateDtoListener extends AnalysisEventListener<TrafficVehicleExcelTemplateDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficVehicleExcelTemplateDtoListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 50;


    List<TrafficVehicleExcelTemplateDto> list = new ArrayList<>();

    private TrafficVehicleInformationService trafficVehicleInformationService;

    public TrafficVehicleExcelTemplateDtoListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
        trafficVehicleInformationService = new TrafficVehicleInformationService();
    }

    @Override
    public void invoke(TrafficVehicleExcelTemplateDto trafficVehicleExcelTemplateDto, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(trafficVehicleExcelTemplateDto));
        list.add(trafficVehicleExcelTemplateDto);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        trafficVehicleInformationService.importExcel(list);
        LOGGER.info("存储数据库成功！");
    }
}
