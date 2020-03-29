package com.shardingjdbc.refresh;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mirko
 * @Description
 * @createTime 2020年03月03日 02:04:00
 */

@Component
public class ConfigRefresh {


    @Resource
    RefreshScope refreshScope;


    @ApolloConfigChangeListener({"shardingjdbc"})
    public void onChange(ConfigChangeEvent event) {
        boolean isChange = false;
        for (String key : event.changedKeys()) {
            if (key.startsWith("jdbc")) {
                isChange = true;
                break;
            }
        }
        if (!isChange) {
            return;
        }
        refreshScope.refresh("jdbcConfig");
    }
}
