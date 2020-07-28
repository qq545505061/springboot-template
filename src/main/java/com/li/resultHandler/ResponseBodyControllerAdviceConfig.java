package com.li.resultHandler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一封装responseBody数据（方式二）
 * ResponseBodyAdvice接口是在Controller执行return之后，在response返回之前执行，用于对response进行一些处理
 */
@ControllerAdvice
public class ResponseBodyControllerAdviceConfig implements ResponseBodyAdvice<Object> {

    /**
     * 设置处理responseBody数据规则
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !methodParameter.getParameterType().equals(Map.class);
    }

    /**
     * responseBody数据处理实现
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Map<String, Object> rst = new HashMap<>();
        rst.put("code", 1000);
        rst.put("data", o);
        return rst;
    }
}
