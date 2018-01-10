package com.sysware.cloud.utils.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * 公共拷贝类
 *
 * @author liuyk
 */
public final class ProcessUtils {

    private static Logger logger = LoggerFactory.getLogger(ProcessUtils.class);

    // private
    private ProcessUtils() {
    }

    /**
     * 拷贝list对象
     *
     * @param clazz 目标类型
     * @param src   原对象集合
     * @return 目标对象集合
     */
    public static <T, R> List<R> process(Class<R> clazz, List<T> src) {
        return processList(clazz, src, (r, s) -> {
        });
    }

    /**
     * 拷贝list对象
     *
     * @param clazz 目标类型
     * @param src   原对象集合
     * @return 目标对象集合
     */
    public static <T, R> List<R> processList(Class<R> clazz, List<T> src, ProcessCallback<R, T> callback) {
        if (src == null || src.isEmpty()) {
            return null;
        }
        List<R> rs = new ArrayList<R>();
        for (T t : src) {
            R process = process(clazz, t, callback);
            rs.add(process);
        }
        return rs;
    }

    /**
     * 拷贝单个对象
     *
     * @param clazz 目标类型
     * @param src   原对象
     * @return 目标对象
     */
    public static <T, R> R process(Class<R> clazz, T src) {
        return process(clazz, src, null);
    }

    /**
     * 拷贝单个对象
     *
     * @param clazz    目标类型
     * @param src      原对象
     * @param callback 回调函数
     * @return 目标对象
     */
    public static <T, R> R process(Class<R> clazz, T src, ProcessCallback<R, T> callback) {
        if (clazz == null || src == null) {
            return null;
        }
        try {
            R r = clazz.newInstance();
            return processObject(r,src,callback);
        } catch (Exception e) {
            logger.error("拷贝对象失败", e);
        }
        return null;
    }

    public static <T, R> R processObject(R r, T src) {
        return processObject(r, src, (r1, src1) -> { });
    }

    public static <T, R > R processObject(R r, T src, ProcessCallback<R, T> callback) {
        try {
            BeanUtils.copyProperties(r, src);
            if (callback != null) {
                callback.call(r, src);
            }
            return r;
        } catch (Exception e) {
            logger.error("拷贝对象失败", e);
        }
        return null;
    }


    /**
     * 转换对象
     *
     * @param response 响应数据
     * @param clazz    目标类型
     * @return 目标对象
     */
    public static <T, R> R process(Response<T> response, Class<R> clazz) {
        return process(response, clazz, (r, t) -> { });
    }

    /**
     * 转换对象
     *
     * @param response 响应数据
     * @param clazz    目标类型
     * @return 目标对象
     */
    public static <T, R> R process(Response<T> response, Class<R> clazz, ProcessCallback<R, T> callback) {
        T analyze = Response.analyze(response);
        return process(clazz, analyze, callback);
    }

    /**
     * 将list集合拷贝指定Clazz的集合
     *
     * @param response 响应数据
     * @param clazz    目标类型
     * @return 目标对象集合
     */
    public static <T extends List<E>, R, E> List<R> processList(Response<T> response, Class<R> clazz) {
        return processList(response, clazz, null);
    }

    /**
     * 将list集合拷贝指定Clazz的集合
     *
     * @param response 响应数据
     * @param clazz    目标类型
     * @return 目标对象集合
     */
    public static <T extends List<E>, R, E> List<R> processList(Response<T> response, Class<R> clazz, ProcessCallback<R, E> callback) {
        T analyze = Response.analyze(response);
        // 如果值为空 转换为空集合
        if (analyze == null) {
            return Collections.emptyList();
        }
        return processList(clazz, (List<E>) analyze, callback);
    }

    /**
     * 将list集合拷贝指定Clazz的集合
     *
     * @param response 响应数据
     * @param clazz    目标类型
     * @return 目标对象集合
     */
    public static <T, R> PageResponse<R> processPage(Response<PageResponse<T>> response, Class<R> clazz) {
        return processPage(response, clazz, null);
    }

    /**
     * 将list集合拷贝指定Clazz的集合
     *
     * @param response 响应数据
     * @param clazz    目标类型
     * @return 目标对象集合
     */
    public static <T, R> PageResponse<R> processPage(Response<PageResponse<T>> response, Class<R> clazz, ProcessCallback<R, T> callback) {
        PageResponse<T> analyze = Response.analyze(response);
        // 如果值为空 转换为空集合
        if (analyze == null) {
            return PageResponse.build(0, null);
        }
        List<R> process = ProcessUtils.processList(clazz, analyze.getDatas(), callback);
        return PageResponse.build(analyze.getTotal(), process);
    }

}
