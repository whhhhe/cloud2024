package com.zmy.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

import static com.zmy.cloud.resp.ReturnCodeEnum.RC200;

@Data
@Accessors(chain = true)
public class Result<T> {
    private String code;
    private String message;
    private T data;
    private long timeStamp;

    public Result(){
        this.timeStamp = System.currentTimeMillis();
    }

    public static <T> Result<T> ok(T t){
        return new Result<T>().setData(t).setCode(RC200.getCode()).setMessage(RC200.getMessage());
    }

    public static <T> Result<T> fail(String code, String message){
        return new Result<T>().setCode(code).setMessage(message).setData(null);
    }
}
