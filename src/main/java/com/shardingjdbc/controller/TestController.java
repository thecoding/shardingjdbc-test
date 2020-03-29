package com.shardingjdbc.controller;

import com.shardingjdbc.dao.BmsUserDao;
import com.shardingjdbc.datasource.JdbcConfig;
import com.shardingjdbc.entity.BmsUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mirko on 2020/3/28.
 */
@RestController
public class TestController implements ApplicationContextAware{


    @Autowired
    BmsUserDao bmsUserDao;

    ApplicationContext applicationContext;

    @Autowired
    RefreshScope refreshScope;


    @RequestMapping("/test")
    public Map<String,Object> getProperties(@RequestParam("version") String version){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test", "test");
        if (!StringUtils.isEmpty(version) && version.equals("1")) {
            map.put("version", "1");
        }
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        map.put("dataSource", dataSource);
        return map;
    }


    @RequestMapping("/update")
    public BmsUser update(){
        BmsUser bmsUser = bmsUserDao.queryById("155739380256440533");
        bmsUser.setSalt("1");
        bmsUserDao.update(bmsUser);
        return bmsUser;
    }


    @RequestMapping("/get")
    public BmsUser getUserById(){
        BmsUser bmsUser = bmsUserDao.queryById("155739380256440533");
        return bmsUser;
    }


    @RequestMapping("/datasource")
    public Object refresh(){
        JdbcConfig jdbcConfig = (JdbcConfig) applicationContext.getBean("jdbcConfig");
        jdbcConfig.getJdbcConfigInfos().forEach(config -> {
            if (config.getName().equals("bms2")) {
                config.setUrl("");
            }
        });
//        BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) applicationContext;
//        BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition("jdbcConfig");
////        beanDefinition.getPropertyValues().add("url", "jdbc:mysql://10.0.0.224:3306/bms?characterEncoding=UTF-8&useSSL=false&allowMultiQueries=true");
//        beanDefinitionRegistry.registerBeanDefinition("jdbcConfig", beanDefinition);
        boolean jdbcRefresh = refreshScope.refresh("jdbcConfig");
        System.out.println(jdbcRefresh);
        boolean createDataSource = refreshScope.refresh("createDataSource");
        System.out.println(createDataSource);
        return jdbcConfig;
    }

    @RequestMapping("/jdbcConfig")
    public Object getBean(){
        JdbcConfig jdbcConfig = (JdbcConfig) applicationContext.getBean("jdbcConfig");
        return jdbcConfig;
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
