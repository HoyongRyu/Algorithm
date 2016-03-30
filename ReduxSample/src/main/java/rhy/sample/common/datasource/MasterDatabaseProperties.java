package rhy.sample.common.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = MasterDatabaseProperties.PREFIX)
public class MasterDatabaseProperties extends DatabaseProperties {
    
    public static final String PREFIX = "mybatis.master";
    
    @Override
    public String toString() {
        return "MasterDatabaseProperties[" + this.getDriverClassName() + "]";
    }
}
