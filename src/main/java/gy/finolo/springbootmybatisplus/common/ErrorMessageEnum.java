package gy.finolo.springbootmybatisplus.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @description: 异常代码枚举类
 * @author: Simon
 * @date: 2021-08-03 14:43
 */
@AllArgsConstructor
public enum ErrorMessageEnum {

    INTERNAL_ERROR  (9999, "internal error"),
    ;

    @Setter
    @Getter
    private int code;

    @Setter
    @Getter
    private String message;
}
