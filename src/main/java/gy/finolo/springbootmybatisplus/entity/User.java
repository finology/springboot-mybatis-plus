package gy.finolo.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@TableName("t_user")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    private LocalDateTime birthday;
}
