package com.baomidou.test.student;

import com.baomidou.test.BaseTest;
import com.baomidou.test.common.util.JSONResult;
import com.baomidou.test.student.service.IStudentService;
import lombok.Value;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: yyg
 * @Date: 2020/1/3 16:05
 * @Description:
 */
public class StudentServiceTest extends BaseTest {
    @Autowired
    IStudentService getListByStuId;


    @Test
    public void getListByStuId(){
        String sId="01";
        JSONResult listByStuId = getListByStuId.getListByStuId(sId);
        System.out.println(listByStuId.getData());
    }


}
