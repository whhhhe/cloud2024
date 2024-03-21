package com.zmy.cloud.controller;

import com.zmy.cloud.entities.Order;
import com.zmy.cloud.resp.Result;
import com.zmy.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/create")
    public Result orderCreate(@RequestBody Order order){
        orderService.createOrder(order);
        return Result.ok(null);
    }

    @GetMapping("/get/{id}")
    public Result getById(@PathVariable("id") Integer id){
        return Result.ok(orderService.getById(id));
    }
}
