package gy.finolo.springbootmybatisplus.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Simon
 * @date: 2021-08-15 14:49
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ac;
    }

    /**
     * 通过bean name获取Bean
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return ac.getBean(name);
    }

    /**
     * 通过class获取Bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return ac.getBean(clazz);
    }

    /**
     * 通过name和class获取Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return ac.getBean(name, clazz);
    }
}
