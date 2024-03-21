package com.zmy.cloud.apis;

import com.zmy.cloud.resp.Result;
import com.zmy.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @auther zzyy
 * @create 2023-11-30 20:22
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi
{
    @Override
    public Result getPayByOrderNo(Integer id)
    {
        return Result.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}