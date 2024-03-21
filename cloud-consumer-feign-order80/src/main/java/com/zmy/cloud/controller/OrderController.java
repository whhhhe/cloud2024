package com.zmy.cloud.controller;

import com.zmy.cloud.apis.PayFeignApi;
import com.zmy.cloud.entities.PayDTO;
import com.zmy.cloud.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/feign")
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/pay/add")
    public Result addOrder(@RequestBody PayDTO payDTO){
        return payFeignApi.addPay(payDTO);
    }

    @DeleteMapping("/pay/del/{id}")
    public Result deletePay(@PathVariable("id") Integer id){
        return payFeignApi.deletePay(id);
    }

    @PutMapping("/pay/update")
    public Result updatePay(@RequestBody PayDTO payDTO){
        return payFeignApi.updatePay(payDTO);
    }

    @GetMapping("/pay/get/{id}")
    public Result getById(@PathVariable("id") Integer id){
        return payFeignApi.getById(id);
    }

    @GetMapping("/pay/info")
    public String getInfo(){
        return payFeignApi.getInfo();
    }
}
