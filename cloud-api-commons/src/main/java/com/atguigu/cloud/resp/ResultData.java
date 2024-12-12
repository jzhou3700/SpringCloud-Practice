package com.atguigu.cloud.resp;

import lombok.Data;

@Data
public class ResultData<T> {

    private String code;
    private String msg;

    private T data;

    private long timestamp;
    public ResultData(){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.SUCCESS.getCode());
        resultData.setMsg(ReturnCodeEnum.SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(String code,String msg){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setData(null);
        return resultData;
    }
}