package com.li.resultHandler;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * responseBody返回数据统一处理实现类
 */
public class ResponseBodyWrapHandler implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler delegate;

    public ResponseBodyWrapHandler(HandlerMethodReturnValueHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return delegate.supportsReturnType(methodParameter);
    }

    /**
     * 处理返回数据
     * @param resultValue 返回值
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @throws Exception
     */
    @Override
    public void handleReturnValue(Object resultValue, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        // 数据处理操作
        System.out.println("----------处理responseBody返回数据----------");
        Map<String, Object> rstMap = new HashMap<>();
        rstMap.put("code", 1000);
        rstMap.put("value", resultValue);
        delegate.handleReturnValue(rstMap, methodParameter, modelAndViewContainer, nativeWebRequest);
    }
}
