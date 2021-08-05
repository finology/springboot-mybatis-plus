package gy.finolo.springbootmybatisplus.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @description: 根据条件查询 User 信息
 * @author: Simon
 * @date: 2020-06-14 15:59
 */
@Data
public class UserListRequest {


    public interface ValidGroup1 {

    }

    public interface ValidGroup2 {

    }

    @NotBlank(groups = ValidGroup1.class)
    @NotBlank(message = "10011=Not blank")
    @Size(min = 3, max = 5, groups = UserListRequest.ValidGroup2.class, message = "10010=参数必须在3-5之间")
//    @Size(min = 3, max = 5)
    private String name;


}

