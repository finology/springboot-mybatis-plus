package gy.finolo.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_user")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
