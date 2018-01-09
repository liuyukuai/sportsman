package com.sysware.cloud.utils.json;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询返回对象
 * 
 * @author liuyk
 */
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = -1816325636807144628L;

    private Long total;

    private List<T> datas;

    public PageResponse() {}

    public PageResponse(Long total, List<T> datas) {
        this.total = total;
        this.datas = datas;
    }

    /**
     * 构建分页对象
     * 
     * @return
     */
    public static <E> PageResponse<E> build(long total, List<E> datas) {
        total = total < 0 ? 0 : total;
        return new PageResponse<E>(total, datas);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
