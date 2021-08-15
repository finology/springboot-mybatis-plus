package gy.finolo.springbootmybatisplus.config;

import gy.finolo.springbootmybatisplus.common.MyMethod;
import gy.finolo.springbootmybatisplus.common.annotation.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: Simon
 * @date: 2021-08-15 16:43
 */
@Slf4j
@Component
public class MyAnnotationScanner implements ApplicationContextAware {

    public static ConcurrentHashMap<String, MyMethod> idMethodMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        log.info(" ------- 2 --------- " + beanDefinitionNames.length);
        for (String beanName : beanDefinitionNames) {
            Object bean = ac.getBean(beanName);
            Class<?> clazz;
            if (AopUtils.isAopProxy(bean)) {
                clazz = AopUtils.getTargetClass(bean);
            } else {
                clazz = bean.getClass();
            }

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {

                Annotation[] annotations = method.getAnnotations();
//                for (Annotation annotation : annotations) {
//                    log.info(annotation.toString());
//                }

                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    // 封闭 1. beanName 2. method 3. paramTypes 4. returnTypes
                    log.debug("beanName: {}", beanName);
                    log.debug("method: {}", method);
                    Parameter[] parameters = method.getParameters();
                    for (Parameter parameter : parameters) {
                        log.debug("parameter: {}", parameter);
                    }
                    log.debug(method.getReturnType().toString());

                    // 放到map 的 key
                    MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                    String key = annotation.commandId();

                    // 放到map 的 value中的类
                    MyMethod myMethod = MyMethod.builder()
                            .beanName(beanName)
                            .method(method)
                            .build();

                    idMethodMap.put(key, myMethod);
                }
            }
        }
    }
}
