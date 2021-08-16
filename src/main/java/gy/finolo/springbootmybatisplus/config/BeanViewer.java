package gy.finolo.springbootmybatisplus.config;

import gy.finolo.springbootmybatisplus.common.annotation.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Simon
 * @date: 2021-08-15 16:04
 */
@Component
@Slf4j
public class BeanViewer {

    @EventListener
    public void showBeansRegistered(ApplicationReadyEvent event) {

        ConfigurableApplicationContext ac = event.getApplicationContext();
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        log.info(" ------- 1 --------- " + beanDefinitionNames.length);
        for (String beanName : beanDefinitionNames) {
            Method[] methods = ac.getBean(beanName).getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    log.info(method.toString());
                } else {
//                    log.info("no: " + method.toString());
                }
            }
        }
    }
}
