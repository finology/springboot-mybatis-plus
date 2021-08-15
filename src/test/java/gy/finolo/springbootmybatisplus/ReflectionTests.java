package gy.finolo.springbootmybatisplus;

import gy.finolo.springbootmybatisplus.common.MyMethod;
import gy.finolo.springbootmybatisplus.config.MyAnnotationScanner;
import gy.finolo.springbootmybatisplus.controller.UserController;
import gy.finolo.springbootmybatisplus.model.vo.user.UserListRequest;
import gy.finolo.springbootmybatisplus.utils.SpringContextUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * @description: 反射调用测试
 * @author: Simon
 * @date: 2021-08-15 14:28
 */
@SpringBootTest
public class ReflectionTests {

    //    @Autowired
//    private UserController userController;
    @Test
    void testAnotherMethodCall() throws InvocationTargetException, IllegalAccessException {

        String commandId = "1";
        UserListRequest userListRequest = new UserListRequest();
        userListRequest.setName("hello");
        Object arg1 = userListRequest;
        Object arg2 = 10L;

        MyMethod myMethod = MyAnnotationScanner.idMethodMap.get("1");
        String beanName = myMethod.getBeanName();
        Object bean = SpringContextUtils.getBean(beanName);
        Method method = myMethod.getMethod();
        Class<?>[] parameterTypes = method.getParameterTypes();

        Object a1 = parameterTypes[0].cast(arg1);
        Object a2 = parameterTypes[1].cast(arg2);

        Object result = method.invoke(bean, a1, a2);
        System.out.println(result);
    }

    @Test
    void testReflectionMethodCall() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        // 注入一个类，然后调用某个方法
        Class<?>[] classes = new Class[2];
        classes[0] = UserListRequest.class;
        classes[1] = Long.class;

        // 1. 使用注入进来的userController
//        Class<? extends UserController> clazz = userController.getClass();

        // 2. 通过SpringContext获取
        UserController userController = SpringContextUtils.getBean("userController", UserController.class);
        Class<? extends UserController> clazz = userController.getClass();


        Method method = clazz.getDeclaredMethod("test", classes);

        UserListRequest userListRequest = new UserListRequest();
        userListRequest.setName("hello");

        Long id = 10L;
        Object[] args = new Object[2];
        args[0] = userListRequest;
        args[1] = id;

        Object result = method.invoke(userController, args);
        System.out.println(result);
    }

}
