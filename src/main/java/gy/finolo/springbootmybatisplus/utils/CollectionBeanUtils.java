package gy.finolo.springbootmybatisplus.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Simon
 * @date: 2021-08-03 18:34
 */
public class CollectionBeanUtils {

    public static <T> List<T> copyListProperties(List<?> source, Class<T> targetClz) {

        if (source == null) {
            throw new IllegalArgumentException("source list should not be null");
        }

        if (targetClz == null) {
            throw new IllegalArgumentException("target Class should not be null");
        }

        return source.stream().map(item -> {
            T t;
            try {
                t = targetClz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            BeanUtils.copyProperties(item, t);
            return t;

        }).collect(Collectors.toList());
    }

}
