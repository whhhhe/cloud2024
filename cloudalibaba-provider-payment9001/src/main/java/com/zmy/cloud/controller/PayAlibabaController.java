package com.zmy.cloud.controller;

import cn.hutool.core.util.RandomUtil;
import com.zmy.cloud.resp.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2023-11-23 17:09
 */
@RestController
public class PayAlibabaController
{
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }

    @GetMapping(value = "/pay/nacos/get/{id}")
    public Result getPayByOrderNo(@PathVariable("id") Integer id)
    {
        if(id > 3) throw new RuntimeException("i=" + id);
        return Result.ok("调用成功！新接口" + id);
    }

}