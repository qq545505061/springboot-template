package com.li.aop;

import com.li.util.BeanUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Aspect
@Component
public class FieldSetValueAspect {

    @Autowired
    private BeanUtil beanUtil;

    @Pointcut("@annotation(com.li.annotation.NeedFieldSetValue)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object FieldSetValue(ProceedingJoinPoint pj) throws Throwable {
        Object rst = pj.proceed();
        beanUtil.FieldSetValueForCol((Collection) rst);
        return rst;
    }
}
