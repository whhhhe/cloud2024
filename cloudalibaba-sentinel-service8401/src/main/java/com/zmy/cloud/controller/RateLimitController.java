package com.zmy.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2023-05-30 16:13
 */
@RestController
@RequestMapping("/rateLimit")
@Slf4j
public class RateLimitController
{
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl", blockHandler = "myBlockHandler", fallback = "myFallBack")
    public String byUrl()
    {
        return "按rest地址限流测试OK";
    }

    public String myBlockHandler(BlockException blockException){
        return "服务不可用!, BlockHandler";
    }

    public String myFallBack(Throwable e){
        return "服务不可用!, FallBack";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,

                             @RequestParam(value = "p2",required = false) String p2){
        return "------testHotKey";
    }
    public String dealHandler_testHotKey(String p1,String p2,BlockException exception)
    {
        return "-----dealHandler_testHotKey";
    }


}
