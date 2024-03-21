package com.zmy.cloud.controller;

import com.zmy.cloud.entities.PayDTO;
import com.zmy.cloud.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    public static final String PAYMENTSRV_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public Result addOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PAYMENTSRV_URL + "/pay/add", payDTO, Result.class);
    }

    @GetMapping("/consumer/pay/del/{id}")
    public Result delOrder(@PathVariable("id") Integer id){
        restTemplate.delete(PAYMENTSRV_URL + "/pay/del/" + id, id, Result.class);
        return Result.ok(null);
    }

    @GetMapping("/consumer/pay/update")
    public Result updateOrder(@RequestBody PayDTO payDTO){
        restTemplate.put(PAYMENTSRV_URL + "/pay/update", payDTO, Result.class);
        return Result.ok(null);
    }

    @GetMapping("/consumer/pay/get/{id}")
    public Result getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENTSRV_URL + "/pay/get/" + id, Result.class, id);
    }

    @GetMapping("/consumer/pay/info")
    public String getInfo(){
        return restTemplate. getForObject(PAYMENTSRV_URL + "/pay/info", String.class);
    }
}
