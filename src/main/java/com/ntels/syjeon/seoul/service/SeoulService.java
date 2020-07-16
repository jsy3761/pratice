package com.ntels.syjeon.seoul.service;

import com.google.gson.Gson;
import com.ntels.syjeon.seoul.repository.SeoulMapper;
import com.ntels.syjeon.seoul.model.SeoulResult;
import com.ntels.syjeon.seoul.model.seoul.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeoulService {
    private static final Logger logger = LoggerFactory.getLogger(SeoulService.class);

    @Autowired
    private ApiService apiService;

    @Autowired
    private SeoulMapper seoulMapper;

    public List<Row> getRowsList() {
        Gson gson = new Gson();
        String json = apiService.callApi("", "");
        List<Row> rowList = gson.fromJson(json, SeoulResult.class).getOctastatapi419().getRow();

        return rowList;
    }

    public Row getRow(String gigan, String jachigu) {
        logger.debug(" getRow param : gigan : {} , jachigu : {}", gigan, jachigu);
        Gson gson = new Gson();
        String json = apiService.callApi(dateConvert(gigan), jachigu);
        List<Row> rowList = gson.fromJson(json, SeoulResult.class).getOctastatapi419().getRow();
        Row row = rowList.get(0);

        seoulMapper.insert(row);

        return row;
    }

    public String dateConvert(String gigan) {
        String[] strs = gigan.split("-");
        String result = "";

        if (strs[1].equals("01") || strs[1].equals("02") || strs[1].equals("03")) {
            result += strs[0] + ".1-4";
        } else if (strs[1].equals("04") || strs[1].equals("05") || strs[1].equals("06")) {
            result += strs[0] + ".2-4";
        } else if (strs[1].equals("07") || strs[1].equals("08") || strs[1].equals("09")) {
            result += strs[0] + ".3-4";
        } else {
            result += strs[0] + ".4-4";
        }

        return result;
    }

}
