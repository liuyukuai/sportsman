package com.sysware.cloud.utils.exception;

/**
 * @author : liuyk
 */
public class FieldNotExistException extends RuntimeException {

    private static final long serialVersionUID = 6448868981820503072L;

    public FieldNotExistException() {
        super();
    }

    public FieldNotExistException(String message) {
        super(message);
    }

    public FieldNotExistException(String message, Throwable e) {
        super(message, e);
    }

    public FieldNotExistException(Throwable e) {
        super(e);
    }
}
