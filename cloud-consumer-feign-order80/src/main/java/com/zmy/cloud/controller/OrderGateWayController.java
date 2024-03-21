package com.zmy.cloud.controller;

import com.zmy.cloud.apis.PayFeignApi;
import com.zmy.cloud.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2023-11-20 16:48
 */
@RestController
@RequestMapping("/feign/pay/gateway")
public class OrderGateWayController
{
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/get/{id}")
    public Result getByIdWithGateway(@PathVariable("id") Integer id)
    {
        return payFeignApi.getByIdWithGateway(id);
    }

    @GetMapping(value = "/info")
    public Result getGatewayInfo()
    {
        return payFeignApi.getGatewayInfo();
    }
}


 