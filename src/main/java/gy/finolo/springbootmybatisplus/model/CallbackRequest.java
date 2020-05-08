package gy.finolo.springbootmybatisplus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @description: Third party callback request
 * 如果第三方传过来的json属性并不是驼峰规则的，就需要用到JsonProperty注解
 * @author: Simon
 * @date: 2020-05-08 21:40
 */
@Data
public class CallbackRequest {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("UserName")
    private String userName;
}
