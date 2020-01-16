package com.baomidou.test.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.test.common.util.JSONResult;
import com.baomidou.test.user.store.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yaoyige
 * @since 2019-12-26
 */
public interface UserService extends IService<User> {
    /**
     * @Description:  获取所有的用户
     * @param
     * @return:
     * @auther: yyg
     * @date: 2019/12/26 13:54
     */
     List<User> getUserLit();

     /**
      * @Description: 根据名称去查询
      * @param
      * @return:
      * @auther: yyg
      * @date: 2019/12/30 10:31
      */
     List<User> getUserListByParams(String name);

     /**
      * @Description:  分页查询
      * @param
      * @return:
      * @auther:
      * @date: 2019/12/30 11:34
      */
     IPage<User> getListUserByPage(Page page, String name);

     /**
      * 根据名称查询年龄最大的
      * @param name 名称
      * @return:
      * @date: 2020/1/2 9:54
      */
     User selectOneByName(String name);

     /**
      * 根据条件删除
      * @param condition 条件
      * @return:
      * @date: 2020/1/2 15:41
      */
     JSONResult deleteUserByCondition(String condition);

     /**
      * 是否可以持续访问某一个接口
      * @param name 接口名称
      * @return:
      * @date: 2020/1/6 10:00
      */
     JSONResult isPersistentProvider(String name);
}
