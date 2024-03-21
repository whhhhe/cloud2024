package com.zmy.cloud.apis;

import com.zmy.cloud.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {

    @PostMapping("/account/decrease")
    Result decrease(@RequestParam("userId")Long userId,@RequestParam("money")Long money);

}
