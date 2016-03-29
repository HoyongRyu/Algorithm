package rhy.sample.common.config;

import rhy.sample.common.init.ConfigurationLoader;

public class RHYConfig {

    /**
     * WEB Proxy IP
     */
    public static String getProxyIP(){
        return ConfigurationLoader.getProperty("proxy.ip");
    }
    
    /**
     * WEB Proxy Port
     */
    public static int getProxyPort(){
        String port = ConfigurationLoader.getProperty("proxy.port");
        return port != null ? Integer.parseInt(port) : 0;
    }
    
    /**
     * T development BaaS 호출 URL
     */
    public static String getUserServiceURL(){
        return ConfigurationLoader.getProperty("user.service.url", "https://apis.sktelecom.com");
    }
    
    /**
     * T development BaaS Master Key
     */
    public static String getUserServiceMasterKey(){
        return ConfigurationLoader.getProperty("user.service.key.master");
    }
    
    /**
     * T development BaaS Rest Key
     */
    public static String getUserServiceRestKey(){
        return ConfigurationLoader.getProperty("user.service.key.rest");
    }
    
    /**
     * T development BaaS Javascript Key
     */
    public static String getUserServiceJavascriptKey(){
        return ConfigurationLoader.getProperty("user.service.key.javascript");
    }
}
