package com.ct.Utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.ct.dao.terminalsDao;
import com.ct.entity.terminals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ImportDataListener extends AnalysisEventListener<terminals> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportDataListener.class);

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<terminals> list = new ArrayList<terminals>();

    private terminalsDao terminalsDao;

    /**
     * 如果使用了Spring，请使用这个构造方法。每次创建Listener的时候需要把Spring管理的类传进来
     * @param terminalsDao
     */
    public ImportDataListener(terminalsDao terminalsDao){
        this.terminalsDao = terminalsDao;
    }

    @Override
    public void invoke(terminals terminals, AnalysisContext analysisContext) {

        LOGGER.info("解析到一条数据:{}", JSON.toJSON(terminals));
        list.add(terminals);
        // 达到BATCH_COUNT了,需要去存储一次数据库，防止几万条数据在内存，容易OOM
        if(list.size() >= BATCH_COUNT){
            saveData();
            LOGGER.info("所有数据解析完成！");
        }

    }

    /**
     *
     * 所有数据解析完成之后会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 存储数据库
     */
    private void saveData(){
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        //terminalsDao.save(list);
        LOGGER.info("存储数据库成功！");
    }
}
