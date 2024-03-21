package com.zmy.cloud.controller;

import com.zmy.cloud.entities.Pay;
import com.zmy.cloud.entities.PayDTO;
import com.zmy.cloud.resp.Result;
import com.zmy.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

import static com.zmy.cloud.resp.ReturnCodeEnum.RC999;

/**
 * @auther zzyy
 * @create 2023-11-03 18:55
 */
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController
{
    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public Result addPay(@RequestBody Pay pay)
    {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        if(i > 0) return Result.ok("成功插入" + i + "条数据!");
        return Result.fail(RC999.getCode(), RC999.getMessage());
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public Result deletePay(@PathVariable("id") Integer id) {
        int delete = payService.delete(id);
        if(delete > 0) return Result.ok("成功删除" + delete + "条数据!");
        return Result.fail(RC999.getCode(), RC999.getMessage());
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public Result updatePay(@RequestBody PayDTO payDTO)
    {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        if(i > 0) return Result.ok("成功修改记录，返回值："+i);
        return Result.fail(RC999.getCode(), RC999.getMessage());
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public Result getById(@PathVariable("id") Integer id)
    {
//        try {
//            TimeUnit.SECONDS.sleep(62);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Pay pay = payService.getById(id);
        if(pay == null) return Result.fail(RC999.getCode(), RC999.getMessage());
        return Result.ok(pay);
    }

    @Value("${server.port}")
    private String port;
    @Value("${zmy.info}")
    String info;
    @GetMapping("/pay/info")
    public String getInfo(){
        return info + "," +  port;
    }
}
