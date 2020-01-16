package com.baomidou.test.user.jwt;

import com.baomidou.test.user.store.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: yyg
 * @Date: 2020/1/14 17:02
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Long> {

    //根据用户名去获取用户信息
    User findByUsername(String userName);
}
