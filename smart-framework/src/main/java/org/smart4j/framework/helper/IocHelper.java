package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 */
public final class IocHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {//循环遍历entry
                Class<?> beanClass = beanEntry.getKey();//key是Class
                Object beanInstance = beanEntry.getValue();//value是实例
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {//遍历所有字段
                        if (beanField.isAnnotationPresent(Inject.class)) {//判断该字段是否有Inject注解标识
                            Class<?> beanFieldClass = beanField.getType();//获得该字段的Class
                            Object beanFieldInstance = beanMap.get(beanFieldClass);//根绝Class去map中获取实例
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);//给该字段设置值
                            }
                        }
                    }
                }
            }
        }
    }
}
