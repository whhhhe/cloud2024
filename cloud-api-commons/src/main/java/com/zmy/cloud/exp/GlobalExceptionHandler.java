package com.zmy.cloud.exp;

import com.zmy.cloud.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.zmy.cloud.resp.ReturnCodeEnum.RC500;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Result exception(Exception e){
        log.error("全局异常信息{}", e.getMessage(), e);
        throw new RuntimeException();
//        return Result.fail(RC500.getCode(), RC500.getMessage());
    }
}
