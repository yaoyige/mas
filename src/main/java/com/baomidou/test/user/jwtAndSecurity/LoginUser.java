package com.baomidou.test.user.jwtAndSecurity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: yyg
 * @Date: 2020/1/15 11:43
 * @Description:
 */
@Data
public class LoginUser implements Serializable {
    private String userName;
    private String passWord;

}
