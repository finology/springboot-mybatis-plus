package gy.finolo.springbootmybatisplus.model;

import lombok.Builder;
import lombok.Data;

/**
 * @description: 返回基础类
 * @author: Simon
 * @date: 2020-06-14 20:52
 */
@Data
@Builder
public class BaseResponse<T> {

    private Integer code;
    private String message;
    private T data;
}
