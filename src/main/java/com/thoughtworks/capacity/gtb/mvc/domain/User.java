package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class User {

    @NotNull(message = "id must not be null")
    private Integer id;
    @NotBlank(message = "type must not be blank")
    @Length(min=3, max=18, message="用户名长度必须在3-18之间")
    @Pattern(regexp = "^\\w+$", message = "用户名只能由字母、数字或下划线组成")
    private String username;
    @NotBlank(message = "color must not be blank")
    @Length(min=5, max=12, message="用户名长度必须在5-12之间")
    private String password;
    @Email
    private String email;

    public User(Integer i, String yangzhengqing, String s, String s1) {
    }

    public Integer getId() {
        return id;
    }
}
