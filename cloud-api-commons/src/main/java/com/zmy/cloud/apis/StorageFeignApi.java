package com.zmy.cloud.apis;

import com.zmy.cloud.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi {
    @PostMapping(value ="/storage/decrease")
    Result decrease(@RequestParam("productId")Long productId, @RequestParam("count")Integer count);
}
