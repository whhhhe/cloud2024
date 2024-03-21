package com.zmy.cloud.apis;

import com.zmy.cloud.entities.PayDTO;
import com.zmy.cloud.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "cloud-gateway", fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignApi {
    @PostMapping("/pay/add")
    Result addPay(@RequestBody PayDTO  payDTO); //增

    @DeleteMapping("/pay/del/{id}")
    Result deletePay(@PathVariable("id") Integer id); //删

    @PutMapping("/pay/update")
    Result updatePay(@RequestBody PayDTO payDTO); //改

    @GetMapping("/pay/get/{id}")
    Result getById(@PathVariable("id") Integer id); //查

    @GetMapping("/pay/info")
    String getInfo();

    @GetMapping("/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/bulkhead/{id}")
    String myBulkhead(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/get/{id}")
    Result getByIdWithGateway(@PathVariable("id") Integer id);
    @GetMapping(value = "/pay/gateway/info")
    Result getGatewayInfo();

}
