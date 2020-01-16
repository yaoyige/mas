package com.baomidou.test.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.test.common.util.JSONResult;
import com.baomidou.test.user.store.domain.User;
import com.baomidou.test.user.store.mapper.UserMapper;
import com.baomidou.test.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yaoyige
 * @since 2019-12-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;


    public List<User> getUserLit() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    public List<User> getUserListByParams(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name",name);
//        queryWrapper.like("name",name);
        queryWrapper.likeLeft("name", name);
//        queryWrapper.likeRight("name",name);
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }

    @Override
    public IPage<User> getListUserByPage(Page page, String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        Page page1 = userMapper.selectPage(page, queryWrapper);
        return page1;
    }

    @Override
    public User selectOneByName(String name) {
        return userMapper.selectOneByName(name);
    }

    @Override
    public JSONResult deleteUserByCondition(String condition) {
        String[] split = condition.split(",");
        userMapper.deleteUserByCondition(split);
        return null;
    }

    @Override
    public JSONResult isPersistentProvider(String name) {
        if(StringUtils.isBlank(name)){
            //接口名不为空
            return JSONResult.errorMsg("接口名为空");
        }
        if(redisTemplate.hasKey(name)){
            //包含key,说明在规定的时间内有访问次数记录
            int i =Integer.parseInt(redisTemplate.boundValueOps(name).get().toString());
            if(i<=5){
                i++;
                redisTemplate.boundValueOps(name).set(i);
                return JSONResult.ok();
            }else{
                return JSONResult.errorMsg("规定时间内的访问次数达到上限,请稍后再试");
            }
        }else{
            //不包含key,说明在规定的时间内没有访问次数
            redisTemplate.boundValueOps(name).set(1);
            redisTemplate.boundValueOps(name).expire(100, TimeUnit.SECONDS);
            return JSONResult.ok();
        }
    }
}
