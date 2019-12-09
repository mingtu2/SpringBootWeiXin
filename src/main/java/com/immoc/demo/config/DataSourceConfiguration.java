package com.immoc.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * @author mingtu
 * @create 2019/12/7  17:09
 */
@Configuration
//配置mybatis的mapper的扫描路径
@MapperScan("com.immoc.demo.dao")
public class DataSourceConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.username}")
    private String jdbcUser;
    @Value("${spring.datasource.password}")
    private String jdbcPassWord;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPassWord);
        dataSource.setJdbcUrl(jdbcUrl);
        //关闭连接后不自动提交
        dataSource.setAutoCommitOnClose(false);
        return  dataSource;
    }
}
