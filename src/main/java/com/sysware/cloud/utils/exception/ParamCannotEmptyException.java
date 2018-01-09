package com.sysware.cloud.utils.exception;

/**
 * 创建云主机异常类
 *
 * @author : liuyk
 * 
 */
public class ParamCannotEmptyException extends RuntimeException {

    private static final long serialVersionUID = 6448868981820503072L;

    public ParamCannotEmptyException() {
        super();
    }

    public ParamCannotEmptyException(String message) {
        super(message);
    }

    public ParamCannotEmptyException(String message, Throwable e) {
        super(message, e);
    }

    public ParamCannotEmptyException(Throwable e) {
        super(e);
    }
}
