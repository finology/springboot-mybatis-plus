package gy.finolo.springbootmybatisplus.model.vo.user;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class AddUserRequest {

    @NotBlank(message = "10002=姓名不能为空")
    private String name;

    @Min(value = 1, message = "10003=最小为1")
    @Max(value = 120, message = "100004=最大为120")
    private Integer age;

}
