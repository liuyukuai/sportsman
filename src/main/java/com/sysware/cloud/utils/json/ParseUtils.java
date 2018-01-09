package com.sysware.cloud.utils.json;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * 转换工具类
 * 
 * @author liuyk
 */
public final class ParseUtils {

    /**
     * 默认最大分页数
     */
    private static final int DEFAULT_MAX_LIMIT = 100;

    /**
     * 默认最小分页数
     */
    private static final int DEFAULT_LIMIT = 20;

    /**
     * 默认最大起始页数
     */
    private static final int DEFAULT_MAX_START = 100;

    /**
     * 默认最小起始页数
     */
    private static final int DEFAULT_MIN_START = 1;

    // private
    private ParseUtils() {}

    /**
     * 解析start参数
     * 
     * @param start start 最大值为1000，若start可能超过该值请使用#start(String start, int maxValue)
     * @return
     */
    public static int start(String start) {
        return start(start, DEFAULT_MAX_START);
    }

    /**
     * 解析start参数
     * 
     * @param start
     * @param maxValue start 最大值,由程序员调用设置。
     * @return
     */
    public static int start(String start, int maxValue) {
        if (StringUtils.isBlank(start)) {
            return DEFAULT_MIN_START;
        }
        try {
            int parseInt = intVal(start);
            return parseInt <= 0 ? DEFAULT_MIN_START : (parseInt > maxValue ? maxValue : parseInt);
        } catch (Exception e) {
            return DEFAULT_MIN_START;
        }
    }

    /**
     * 解析分页条数
     * 
     * @param limit 默认值为20
     * @return
     */
    public static int limit(String limit) {
        return limit(limit, DEFAULT_LIMIT);
    }

    /**
     * 解析分页条数limit
     * 
     * @param limit
     * @param defaultValue limit的默认值，limit最大分页数为100,防止分页数过大出现问题
     * @return
     */
    public static int limit(String limit, int defaultValue) {
        try {
            int parseInt = intVal(limit);
            return parseInt <= 0 ? defaultValue : (parseInt > DEFAULT_MAX_LIMIT ? DEFAULT_MAX_LIMIT : parseInt);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 计算页数
     * 
     * @param total 总数
     * @param limit 每页条数
     * @return
     */
    public static int page(long total, int limit) {
        if (limit <= 0 || total <= 0) {
            return 0;
        }
        return (int) Math.ceil(total * 1.0 / limit);
    }

    /**
     * 加密电话号码
     * 
     * @param phone
     * @return
     */
    public static String phone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return phone;
        }
        int len = phone.length();
        return phone.substring(0, 3) + "*****" + phone.substring(len - 3, len);
    }

    /**
     * 转换为int类型数据
     * 
     * @param val 非法字符转换成0
     * @return
     */
    public static int intVal(String val) {
        return intVal(val, 0);
    }

    /**
     * 转换为int类型数据
     * 
     * @param intVal
     * @param defautValue 默认值
     * @return
     */
    public static int intVal(String val, int defautValue) {
        try {
            return NumberUtils.createNumber(val).intValue();
        } catch (Exception e) {
            return defautValue;
        }
    }

    /**
     * 转换为long类型数据
     * 
     * @param val 非法字符转换成0
     * @return
     */
    public static long longVal(String val) {
        return longVal(val, 0L);
    }

    /**
     * 转换为long类型数据
     * 
     * @param val
     * @param defautValue 默认值
     * @return
     */
    public static long longVal(String val, long defautValue) {
        try {
            return NumberUtils.createNumber(val).longValue();
        } catch (Exception e) {
            return defautValue;
        }
    }
}
