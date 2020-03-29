package com.shardingjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.shardingjdbc.datasource.Global;
import com.shardingjdbc.datasource.JdbcConfig;
import com.shardingjdbc.datasource.SubJdbcConfig;
import io.shardingsphere.api.config.MasterSlaveRuleConfiguration;
import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mirko on 2020/3/28.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class ShardingDataSource {

    private static final Logger logger = LoggerFactory.getLogger(ShardingDataSource.class);


    @Bean(name= "jdbcConfig")
    @ConfigurationProperties(prefix = "jdbc")
    @RefreshScope
    public JdbcConfig jdbcConfig(){
        return new JdbcConfig();
    }



    public Map<String,DataSource> getDataSource(JdbcConfig jdbcConfig){
        Global global = jdbcConfig.getGlobal();
        List<SubJdbcConfig> jdbcConfigInfos = jdbcConfig.getJdbcConfigInfos();
        if(jdbcConfigInfos == null || jdbcConfigInfos.isEmpty()){
            throw new RuntimeException("没有找到jdbc配置信息...");
        }
        Map<String, DataSource> result = new HashMap<>(jdbcConfig.getJdbcConfigInfos().size(), 1);
        for (SubJdbcConfig config : jdbcConfigInfos) {
            logger.info("SubJdbcConfig: --> " + config.toString());

            DruidDataSource datasource = new DruidDataSource();
            datasource.setUrl(config.getUrl());
            datasource.setUsername(config.getUser());
            datasource.setPassword(config.getPassword());

            datasource.setDriverClassName(global.getDriverClassName());
            datasource.setInitialSize(global.getPoolSize());
            datasource.setMinIdle(global.getMinIdle());
            datasource.setMaxWait(global.getMaxWait());
            datasource.setMaxActive(global.getMaxActive());
            datasource.setMinEvictableIdleTimeMillis(global.getMinEictableIdleTimeMillis());
            result.put(config.getName(), datasource);
        }
        return result;

    }




    @Bean(name = "diyDataSource")
    @RefreshScope
    public DataSource createDataSource(@Autowired JdbcConfig jdbc) throws SQLException {
        Global global = jdbc.getGlobal();
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig.setName(StringUtils.isEmpty(global.getDefaultDatasource()) ? "datasource" : global.getDefaultDatasource());
        masterSlaveRuleConfig.setMasterDataSourceName(global.getMaster());
        masterSlaveRuleConfig.setSlaveDataSourceNames(StringUtils.isEmpty(global.getSlave()) ? new ArrayList<>() : Arrays.asList(global.getSlave().split(",")));

        Map<String, DataSource> result = getDataSource(jdbc);

        logger.info(ShardingDataSource.class.getName(),"加载数据库信息..");
        if(!result.containsKey(masterSlaveRuleConfig.getMasterDataSourceName())){
            throw new RuntimeException("没有找到 master 节点"+masterSlaveRuleConfig.getMasterDataSourceName()+"jdbc配置信息...");
        }
        masterSlaveRuleConfig.getSlaveDataSourceNames().forEach(str -> {
            if(!result.containsKey(str)){
                throw new RuntimeException("没有找到 slave 节点"+str+"jdbc配置信息...");
            }
        });

        return MasterSlaveDataSourceFactory.createDataSource(result, masterSlaveRuleConfig, new ConcurrentHashMap<>(), new Properties());
    }



    @Bean
    public PlatformTransactionManager platformTransactionManager(@Autowired DataSource datasource){
        return new DataSourceTransactionManager(datasource);
    }
}
