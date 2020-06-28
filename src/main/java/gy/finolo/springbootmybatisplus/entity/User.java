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
    private String username;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
