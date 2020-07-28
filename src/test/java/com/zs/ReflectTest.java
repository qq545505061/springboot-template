package com.zs;

import com.li.annotation.NeedSetFieldValue;
import com.li.annotation.SetFieldValue;
import com.li.entity.Order;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ReflectTest implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) throws Exception {
        Order order = new Order();
        order.setId(1);
        order.setOrderNo("123");
        order.setUserId(2);

        Class<?> clazz = order.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            String name = field.getName();
            System.out.println(name);
            String methodName = "get" + name.substring(0,1).toUpperCase() + name.substring(1);
            System.out.println(methodName);
            Method method = clazz.getMethod(methodName, null);
            Type t = method.getGenericReturnType();
            System.out.println(t.getTypeName());
            Class rt = Class.forName(t.getTypeName());
            Object r = method.invoke(order, null);
            System.out.println(r);

            SetFieldValue sv = field.getAnnotation(SetFieldValue.class);
            if(sv == null)
                continue;
            Class<?> bean = sv.beanClass();
            Field paramField = clazz.getDeclaredField(sv.param());
            Method method2 = bean.getMethod(sv.method(), paramField.getType());
            boolean needInnerField = !StringUtils.isEmpty(sv.targetField());
            paramField.setAccessible(true);
            Object paramValue = paramField.get(order);
            if(paramValue != null) {
                System.out.println(paramValue);
                Object obj = applicationContext.getBean(bean);
                Object rst = method2.invoke(obj, paramValue);
                System.out.println(rst);
            }
        }
    }

    public void getObj(String name) {
        Object bean = this.applicationContext.getBean(name);
    }
}
