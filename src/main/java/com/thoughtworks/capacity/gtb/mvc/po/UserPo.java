package com.thoughtworks.capacity.gtb.mvc.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPo {

    @NotBlank(message = "用户名不能为空")
    @Length(min=3, max=18, message="用户名长度必须在3-18之间")
    @Pattern(regexp = "^\\w+$", message = "用户名只能由字母、数字或下划线组成")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min=5, max=12, message="密码长度必须在5-12之间")
    private String password;

    @Email
    private String email;
}
