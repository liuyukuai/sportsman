package com.sysware.cloud.common;

import com.google.gson.JsonObject;
import com.sysware.cloud.utils.json.GsonUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sysware.cloud.utils.json.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    public WebExceptionHandler() {
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public Response<String> exce(Exception e) {
        this.logger.error(e.getMessage(), e);
        if ("MissingServletRequestParameterException".equals(e.getClass().getSimpleName())) {
            try {
                Class<? extends Exception> class1 = e.getClass();
                String name = (String)class1.getMethod("getParameterName").invoke(e);
                return Response.error("参数异常：" + name + "不能为空。");
            } catch (Exception var4) {
                ;
            }
        }

        return Response.error("系统内部错误，请稍后重试。");
    }

    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Response<String> exce(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> errors = result.getFieldErrors();
        List<JsonObject> messages = new ArrayList();
        Iterator var5 = errors.iterator();

        while(var5.hasNext()) {
            FieldError error = (FieldError)var5.next();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(error.getField(), error.getDefaultMessage());
            messages.add(jsonObject);
        }

        this.logger.error("参数异常: method={}", e.getParameter().getMethod());
        this.logger.error("参数异常: detail={} ", messages);
        return Response.error(GsonUtils.toJson(messages));
    }

    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Response<String> exce(HttpMessageNotReadableException e) {
        return Response.error("请求body为空,请确认是否有请求体。");
    }

    @ResponseBody
    @ExceptionHandler({SQLException.class})
    public Response<String> exce(SQLException e) {
        this.logger.error("sql exception:" + e.getMessage(), e);
        return Response.error("系统内部错误，请稍后重试。");
    }

    @ResponseBody
    @ExceptionHandler({DataIntegrityViolationException.class})
    public Response<String> exce(DataIntegrityViolationException e) {
        this.logger.error("sql exception:" + e.getMessage(), e);
        ConstraintViolationException ex = (ConstraintViolationException)e.getCause();
        return Response.error("[" + ex.getConstraintName() + "]名称重复。");
    }
}
