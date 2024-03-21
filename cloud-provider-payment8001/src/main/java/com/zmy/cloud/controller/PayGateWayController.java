package com.zmy.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.zmy.cloud.entities.Pay;
import com.zmy.cloud.resp.Result;
import com.zmy.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

/**
 * @auther zzyy
 * @create 2023-11-20 13:09
 */
@RestController
public class PayGateWayController
{
    @Resource
    private PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public Result<Pay> getByIdWithGateway(@PathVariable("id") Integer id)
    {
        Pay pay = payService.getById(id);

        return Result.ok(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public Result<String> getGatewayInfo()
    {
        return Result.ok("gateway info test："+ IdUtil.simpleUUID());
    }
    @GetMapping(value = "/pay/gateway/filter")
    public Result<String> getGatewayFilter(HttpServletRequest request)
    {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名: " + headName +"\t\t\t"+"请求头值: " + headValue);
            if(headName.equalsIgnoreCase("X-Request-zmy1")
                    || headName.equalsIgnoreCase("X-Request-zmy2")) {
                result = result+headName + "\t " + headValue +" ";
            }
        }
        return Result.ok("getGatewayFilter 过滤器 test： "+result+" \t "+ DateUtil.now());
    }

}
