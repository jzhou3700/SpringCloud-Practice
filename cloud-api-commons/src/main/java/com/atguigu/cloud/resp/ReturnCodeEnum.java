package com.atguigu.cloud.resp;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReturnCodeEnum {

    SUCCESS("200", "成功"),
    PARAM_ERROR("400", "参数错误"),
    NOT_FOUND("404", "未找到"),
    UNAUTHORIZED("401", "未授权"),
    FORBIDDEN("403", "禁止访问"),
    NOT_IMPLEMENTED("501", "未实现"),
    SERVICE_UNAVAILABLE("503", "服务不可用"),
    GATEWAY_TIMEOUT("504", "网关超时"),
   REQUEST_TIMEOUT("408", "请求超时"),
    INTERNAL_SERVER_ERROR("500", "内部服务器错误");
    private String code;
    private String msg;
    ReturnCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(String code){
        for(ReturnCodeEnum returnCodeEnum : ReturnCodeEnum.values()){
            if(returnCodeEnum.getCode().equals(code)){
                return returnCodeEnum.getMsg();
            }
        }
        return null;
    }

    public static ReturnCodeEnum getEnum(String code){
        return Arrays.stream(ReturnCodeEnum.values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);

    }
    private static int test(int X){
        try {
            ++X;
            return X;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ++X;
        }
        return 0;
    }
}