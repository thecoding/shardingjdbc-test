package com.shardingjdbc;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by Mirko on 2020/3/28.
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@MapperScan(value = {"com.shardingjdbc.dao"})
@EnableApolloConfig
public class ShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }
}
