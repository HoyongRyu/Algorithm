package rhy.sample.common.util;

import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class);
    
    @SuppressWarnings("unchecked")
    public static Map<String, Object> convertJSONtoMap(Object jsonSource) {
        Map<String, Object> result = null;
        try {
            if (jsonSource instanceof InputStream){
                result = new ObjectMapper().readValue((InputStream)jsonSource, HashMap.class);
            }else if (jsonSource instanceof String){
                result = new ObjectMapper().readValue((String)jsonSource, HashMap.class);
            }else if (jsonSource instanceof Reader){
                result = new ObjectMapper().readValue((Reader)jsonSource, HashMap.class);
            }
        } catch (Exception e){
            LOGGER.error("# ERROR convertJSONtoMap", e);
        }
        return result;
    }
}
