package com.example.demo.function;

import com.example.demo.entity.Result;

public class ResultBean {


    public static Result success() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result success(Object data, String msg) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static Result success(String msg) {
        return success(msg, null);
    }

    public static Result failure() {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        return result;
    }

    public static Result failure(String msg) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setMsg(msg);
        return result;
    }

}