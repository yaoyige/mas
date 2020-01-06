package com.baomidou.test.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.test.BaseTest;
import com.baomidou.test.user.service.UserService;
import com.baomidou.test.user.store.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: yyg
 * @Date: 2019/12/26 13:57
 * @Description:
 */
public class UserServiceTest extends BaseTest {
    @Autowired
    UserService userService;

    @Test
    public void getUserList() {
        List<User> userLit = userService.getUserLit();
        for (User user : userLit) {
            System.out.println("用户名称:" + user.getName());
        }
    }

    @Test
    public void getUserListByParams() {
        String name = "J";
        List<User> userLit = userService.getUserListByParams(name);
        for (User user : userLit) {
            System.out.println("用户名称:" + user.getName());
        }
    }

    /**
     * @param
     * @return:
     * @date: 2019/12/31 14:48
     */

    @Test
    public void getListUserByPage() {
        Page<User> page = new Page<>();
        //当前页从0开始
        page.setCurrent(1);
        page.setSize(10);
        page.addOrder(OrderItem.asc("age"));
        String name = "J";
        IPage<User> listUserByPage = userService.getListUserByPage(page, name);
        List<User> records = listUserByPage.getRecords();
        for (User user : records) {
            System.out.println("用户名称:" + user.getName());
        }
    }


    @Test
    public void selectOneByName() {
        String name = "J";
        userService.selectOneByName(name);
    }

    @Test
    public void deleteUser(){
        String conditon = "7,8,9,10";
        userService.deleteUserByCondition(conditon);
    }
}
