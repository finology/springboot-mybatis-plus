package gy.finolo.springbootmybatisplus.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Order implements Serializable {

    private Long id;
    private String name;
    private String messageId;
}
