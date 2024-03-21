package com.zmy.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Retryer retryer(){
        return Retryer.NEVER_RETRY; //openfeign默认配置不开启重试策略

        //最大请求次数为3(1+2)，初始间隔时间为100ms,重试间最大间隔时间为1s
//        return new Retryer.Default(100, 1, 3);
    }

    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }
}
