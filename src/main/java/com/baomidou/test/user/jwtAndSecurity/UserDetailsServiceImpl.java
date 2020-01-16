package com.baomidou.test.user.jwtAndSecurity;

import com.baomidou.test.user.jwt.UserRepository;
import com.baomidou.test.user.store.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther: yyg
 * @Date: 2020/1/15 10:51
 * @Description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        return new JwtUser(user);
    }
}
