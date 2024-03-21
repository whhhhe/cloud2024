package com.zmy.cloud.apis;

import com.zmy.cloud.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther zzyy
 * @create 2023-11-30 20:20
 */
@FeignClient(value = "nacos-payment-provider", fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi
{
    @GetMapping(value = "/pay/nacos/get/{id}")
    Result getPayByOrderNo(@PathVariable("id") Integer id);
}
 