package com.li.util;

import com.li.annotation.FieldSetValue;
import com.li.annotation.NeedFieldSetValue;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class BeanUtil implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Object FieldSetValueForCol(Collection col) throws Exception {
        Class<?> clazz = col.iterator().next().getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            // 判断字段上是否有注解
            FieldSetValue nfs = field.getAnnotation(FieldSetValue.class);
            if(nfs == null)
                continue;
            // 设置字段可操作
            field.setAccessible(true);
            // 获取执行类
            Class<?> beanClass = nfs.beanClass();
            // 实例化执行类
            Object bean = this.applicationContext.getBean(beanClass);

            // 获取执行方法
            Method method = beanClass.getMethod(nfs.method(), clazz.getDeclaredField(nfs.param()).getType());
            // 缓存
            Map<String, Object> cache = new HashMap<>();

            for(Object obj : col) {
                // 获取参数字段
                Field paramField = obj.getClass().getDeclaredField(nfs.param());
                paramField.setAccessible(true);
                Object paramValue = paramField.get(obj);

                Object value = null;
                if(paramValue != null) {
                    String cacheName = nfs.param() + "-" + paramValue.toString();
                    value = cache.get(cacheName);
                    if(value == null) {
                        // 执行方法获取结果
                        Object rstObj = method.invoke(bean, paramValue);
                        Field targetField = rstObj.getClass().getDeclaredField(nfs.targetField());
                        targetField.setAccessible(true);
                        value = targetField.get(rstObj);
                        cache.put(cacheName, value);
                    }
                }
                // 设置目标值
                field.set(obj, value);
            }
        }
        return col;
    }
}
