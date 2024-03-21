package com.zmy.cloud.controller;

import cn.hutool.core.util.RandomUtil;
import com.zmy.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @auther zzyy
 * @create 2023-05-24 15:35
 */
@RestController
public class FlowLimitController
{

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    /**流控-链路演示demo
     * C和D两个请求都访问flowLimitService.common()方法，阈值到达后对C限流，对D不管
     */
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testC")
    public String testC()
    {
        flowLimitService.common();
        return "------testC";
    }
    @GetMapping("/testD")
    public String testD()
    {
        flowLimitService.common();
        return "------testD";
    }
    @GetMapping("/testE")
    public String testE()
    {
        System.out.println(System.currentTimeMillis()+"      testE,排队等待");
        return System.currentTimeMillis()+"      testE,排队等待";
    }

    @GetMapping("/testF")
    public String testF()
    {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "------------TestF";
    }
    @GetMapping("/testG")
    public String testG(){
        int i = RandomUtil.randomInt(0, 10);
        try {
            if(i > 3){
                int t = i/0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return "--------testG调用成功i=" + i;
    }
    @GetMapping("/testH")
    public String testH(){
        int i = RandomUtil.randomInt(0, 10);
        try {
            if(i > 3){
                int t = i/0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return "--------testH调用成功i=" + i;
    }
}
 