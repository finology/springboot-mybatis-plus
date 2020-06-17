package gy.finolo.springbootmybatisplus.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddUserRequest {

    private String name;
    private Integer age;

}
