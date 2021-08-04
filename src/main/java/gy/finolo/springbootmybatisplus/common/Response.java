package gy.finolo.springbootmybatisplus.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @description: 返回基础类
 * @author: Simon
 * @date: 2020-06-14 20:52
 */
@Data
@Builder
@AllArgsConstructor
public class Response<T> {

    private Integer code;
    private String message;
    private T data;

    public static Response success() {

        return Response
                .builder()
                .code(0)
                .message("Success")
                .build();
    }

    // 第一个<T>代表定义一个泛型方法，方法持有一个泛型T，第二个<T>代表泛型类，第二、三个代表使用泛型T
    public static <T> Response<T> success(T t) {

        return Response
                .<T>builder()
                .code(0)
                .data(t)
                .message("Success")
                .build();
    }

    public static <T> Response<T> success(T t, String message) {

        return Response
                .<T>builder()
                .code(0)
                .data(t)
                .message(message)
                .build();
    }

    public static Response fail(int code, String message) {

        return Response.builder()
                .code(code)
                .message(message)
                .build();
    }

}
