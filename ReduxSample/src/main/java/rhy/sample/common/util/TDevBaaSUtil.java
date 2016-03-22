package rhy.sample.common.util;

import java.util.HashMap;
import java.util.Map;

import rhy.sample.common.config.RHYConfig;

public class TDevBaaSUtil {
    public static Map<String, String> getHeaderMap(){
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("TDCProjectKey", RHYConfig.getUserServiceRestKey());
        headerMap.put("Content-Type", "application/json; charset=utf-8");
        return headerMap;
    }
}
