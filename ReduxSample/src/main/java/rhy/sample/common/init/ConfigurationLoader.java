package rhy.sample.common.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {

    private final String configFileName = "src/main/resources/config/config.properties";

    private static Properties PROPS = new Properties();

    public void refreshConfiguration() {
        PROPS.clear();
        loadConfiguration();
    }

    private void loadConfiguration() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(configFileName)));
            PROPS.load(br);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { 
                if (br != null) br.close();
            } catch (IOException e) {}
        }
    }

    public static String getProperty(String key) {
        return getProperty(key, null);
    }

    public static String getProperty(String key, String defaultValue) {
        return PROPS.containsKey(key) ? PROPS.getProperty(key) : defaultValue;
    }
}
