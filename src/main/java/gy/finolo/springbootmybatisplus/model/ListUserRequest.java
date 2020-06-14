package gy.finolo.springbootmybatisplus.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @description: 根据条件查询 User 信息
 * @author: Simon
 * @date: 2020-06-14 15:59
 */
@Data
public class ListUserRequest {


    public interface ValidGroup1 {

    }

    public interface ValidGroup2 {

    }

    @NotBlank(groups = ValidGroup1.class)
    @Size(min = 3, max = 5, groups = ListUserRequest.ValidGroup2.class)
//    @Size(min = 3, max = 5)
    private String name;


}

