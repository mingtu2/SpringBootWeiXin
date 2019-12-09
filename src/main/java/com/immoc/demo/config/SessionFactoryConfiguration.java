package com.immoc.demo.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;


/**
 * @author mingtu
 * @create 2019/12/7  17:33
 */
@Configuration
public class SessionFactoryConfiguration {
    @Autowired
    private DataSource dataSource;
    private final String entityPackage="com.immoc.demo.entity";
    private final String mapperPath="/mapper/*.xml";
    @Value("${mybatis.config-location}")
    private String mybatisConfigFilePath;
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSessionFactory() throws IOException {
        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
        sessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        //指定mapper的路径
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        String packageSearchPath=PathMatchingResourcePatternResolver.CLASSPATH_URL_PREFIX+mapperPath;
        //设置映射实体文件
        sessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        //设置数据源
        sessionFactoryBean.setDataSource(dataSource);
        //设置实体类对应的包
        sessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sessionFactoryBean;
    }
}
