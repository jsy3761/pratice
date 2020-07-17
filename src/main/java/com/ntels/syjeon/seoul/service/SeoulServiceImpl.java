package com.ntels.syjeon.seoul.service;

import com.google.gson.Gson;
import com.ntels.syjeon.seoul.dao.SeoulMapper;
import com.ntels.syjeon.seoul.model.ApiResponse;
import com.ntels.syjeon.seoul.model.seoul.Row;
import com.ntels.syjeon.seoul.util.HttpUtil;
import com.ntels.syjeon.seoul.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Seoul ServiceImpl
 * @author syjeon@ntels.com
 */
@Service
public class SeoulServiceImpl implements SeoulService {
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SeoulServiceImpl.class);

    /**
     * Http Util -> api call
     */
    @Autowired
    private HttpUtil httpUtil;

    /**
     * String Util -> String gigan 변환
     */
    @Autowired
    private StringUtil stringUtil;

    /**
     * Seoul Mapper -> Insert
     */
    @Autowired
    private SeoulMapper seoulMapper;

    @Override
    public List<Row> getRowsList() {
        Gson gson = new Gson();
        String json = httpUtil.callApi("", "");
        List<Row> rowList = gson.fromJson(json, ApiResponse.class).getOctastatapi419().getRow();

        return rowList;
    }

    @Override
    public Row getRow(String gigan, String jachigu) {
        logger.debug(" getRow param : gigan : {} , jachigu : {}", gigan, jachigu);
        Gson gson = new Gson();
        String json = httpUtil.callApi(stringUtil.dateConvert(gigan), jachigu);
        List<Row> rowList = gson.fromJson(json, ApiResponse.class).getOctastatapi419().getRow();
        Row row = rowList.get(0);

        seoulMapper.insert(row);

        return row;
    }

}
