package com.baomidou.test.sys.service.impl;

import com.baomidou.test.sys.store.domain.SysUser;
import com.baomidou.test.sys.store.mapper.SysUserMapper;
import com.baomidou.test.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author yaoyige
 * @since 2019-12-30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements IUserService {

}
