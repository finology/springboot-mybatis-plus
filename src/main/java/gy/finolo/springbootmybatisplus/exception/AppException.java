package gy.finolo.springbootmybatisplus.exception;

import gy.finolo.springbootmybatisplus.common.ErrorMessageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: Simon
 * @date: 2021-08-03 16:51
 */
@Data
@AllArgsConstructor
public class AppException extends RuntimeException {

    private Integer code;
    private String message;

    public AppException(ErrorMessageEnum errorMessageEnum) {
        this(errorMessageEnum.getCode(), errorMessageEnum.getMessage());
    }
}
