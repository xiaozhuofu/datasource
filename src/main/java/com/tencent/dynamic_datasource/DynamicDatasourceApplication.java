package com.tencent.dynamic_datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.tencent",exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.tencent.dao")
public class DynamicDatasourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceApplication.class, args);
    }
}
