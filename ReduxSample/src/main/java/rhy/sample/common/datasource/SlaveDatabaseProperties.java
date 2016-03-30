package rhy.sample.common.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = SlaveDatabaseProperties.PREFIX)
public class SlaveDatabaseProperties extends DatabaseProperties {
    
    public static final String PREFIX = "mybatis.slave";
    
    @Override
    public String toString() {
        return "SlaveDatabaseProperties[" + this.getDriverClassName() + "]";
    }
    
}
