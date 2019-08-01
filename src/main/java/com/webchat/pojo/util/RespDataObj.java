package com.webchat.pojo.util;

import java.lang.reflect.Array;
import java.util.List;

public class RespDataObj {
    private boolean success;
    private Object data;
    private int total;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
        if(data.getClass().isArray()){
            int length= Array.getLength(data);
            setTotal(length);
        }else if(data instanceof java.util.List){
            setTotal(((List) data).size());
        }else {
            setTotal(1);
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
