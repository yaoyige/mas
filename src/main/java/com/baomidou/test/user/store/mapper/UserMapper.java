package com.baomidou.test.user.store.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.test.user.store.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yaoyige
 * @since 2019-12-26
 */
public interface UserMapper extends BaseMapper<User> {


    /**
     *
     * @param
     * @return:
     * @date: 2020/1/2 9:33
     */
    User selectOneByName(@Param("name") String name);

   /**
    * 删除多个
    * @param
    * @return:
    * @date: 2020/1/2 15:51
    */
    int deleteUserByCondition(@Param("listId")String[] listId);

    @Select("select * from user")
    List<User> getUserList(Page page);
}
