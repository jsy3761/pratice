package com.ntels.syjeon.seoul.util;

import org.springframework.stereotype.Component;

/**
 * String Util
 * @author syjeon@ntels.com
 */
@Component
public class StringUtil {

    /**
     * input Type Date로 받아온 gigan을 처리하여 Api규격으로 변환하여 리턴
     * ex) 2019-08 -> 2019년 3/4분기 이므로 -> 2020.3-4
     * @param gigan input type Date String (yyyy-mm)
     * @return String gigan(yyyy.n-n)
     */
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
