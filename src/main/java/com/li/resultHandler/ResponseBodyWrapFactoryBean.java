package com.li.resultHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置过滤bean原则
 */
public class ResponseBodyWrapFactoryBean implements InitializingBean {

    @Autowired
    private RequestMappingHandlerAdapter adapter;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        // 获取的returnValueHandlers为不可修改的集合，所以需要重新封装
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(returnValueHandlers);
        decorateHandler(handlers);
        adapter.setReturnValueHandlers(handlers);
    }

    /**
     * 处理指定handler
     * @param handlers
     */
    public void decorateHandler(List<HandlerMethodReturnValueHandler> handlers) {
        for(HandlerMethodReturnValueHandler handler : handlers) {
            if(handler instanceof RequestResponseBodyMethodProcessor) {
                System.out.println("----------封装responseBody返回数据----------");
                ResponseBodyWrapHandler wrapHandler = new ResponseBodyWrapHandler(handler);
                int index = handlers.indexOf(handler);
                handlers.set(index, wrapHandler);
                break;
            }
        }
    }
}
