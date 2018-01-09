package com.sysware.cloud.utils.exception;

/**
 * http请求异常类
 *
 * @author : liuyk
 * 
 */
public class URLCannotEmptyException extends RuntimeException {
    
    private static final long serialVersionUID = 6448868981820503072L;

    public URLCannotEmptyException() {
        super();
    }

    public URLCannotEmptyException(String message) {
        super(message);
    }

    public URLCannotEmptyException(String message, Throwable e) {
        super(message, e);
    }

    public URLCannotEmptyException(Throwable e) {
        super(e);
    }
}
