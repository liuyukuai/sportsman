package com.sysware.cloud.utils.json;

/**
 * 对象转换回调函数
 * 
 * @author liuyk
 */
@FunctionalInterface
public interface ProcessCallback<R, S> {

    /**
     * 回调函数
     * 
     * @param dest 目标对象
     * @param src 原始对象
     */
    void call(R dest, S src);
}
