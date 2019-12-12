package com.tencent.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DatasourceConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${mybatis.mapper-locations}")
    private String mapperLocation;


    /**
     * 创建数据源
     * @return
     */
    @Bean
    public DataSource getDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driverClassName);
        return hikariDataSource;
    }


    /**
     * bean 工厂
     */
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource getDataSource){
        System.err.println(mapperLocation);
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //注入数据源
        sqlSessionFactoryBean.setDataSource(getDataSource);
        //配置映射文件路径
        try {
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactoryBean;
    }

}
