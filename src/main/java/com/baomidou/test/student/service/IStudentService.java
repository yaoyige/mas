package com.baomidou.test.student.service;

import com.baomidou.test.common.util.JSONResult;
import com.baomidou.test.student.store.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.test.student.vo.StudentVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yaoyige
 * @since 2020-01-03
 */
public interface IStudentService extends IService<Student> {

    /**
     * 根据学生id，查询学生下所有的课程
     * @param  sId
     * @return:
     * @date: 2020/1/3 15:54
     */
    JSONResult getListByStuId(String sId);
}
