package com.zym.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 注解：@ConfigurationProperties 用在类上时，需要与 @Component 配合
 */
@Component
@ConfigurationProperties(prefix = "com.mysql")
public class MysqlProperties {

    private String host;
    private int port;
    private String dbname;
    private String uname;
    private String passwd;

    @Override
    public String toString() {
        return "host : " + host + "<br>" +
                "port : " + port + "<br>" +
                "dbname : " + dbname + "<br>" +
                "uname : " + uname + "<br>" +
                "passwd : " + passwd;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
