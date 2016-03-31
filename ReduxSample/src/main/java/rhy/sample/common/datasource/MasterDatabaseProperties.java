package rhy.sample.common.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = MasterDatabaseProperties.PREFIX)
public class MasterDatabaseProperties implements DatabaseProperties {
    
    public static final String PREFIX = "mybatis.master";
    
    private String driverClassName;
    
    private String url;
    
    private String username;
    
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "MasterDatabaseProperties[" + this.getDriverClassName() + "]";
    }

}
