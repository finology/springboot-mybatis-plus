package gy.finolo.springbootmybatisplus.model.vo.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: Simon
 * @date: 2021-08-03 18:10
 */
@Data
@ApiModel
public class UserVo {

    @ApiModelProperty("id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    private Integer age;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
