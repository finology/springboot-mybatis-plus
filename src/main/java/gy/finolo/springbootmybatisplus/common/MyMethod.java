package gy.finolo.springbootmybatisplus.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Simon
 * @date: 2021-08-15 18:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyMethod {

    private Method method;

    private String beanName;
}
