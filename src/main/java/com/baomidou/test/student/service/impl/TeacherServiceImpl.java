package com.baomidou.test.student.service.impl;

import com.baomidou.test.student.store.domain.Teacher;
import com.baomidou.test.student.store.mapper.TeacherMapper;
import com.baomidou.test.student.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yaoyige
 * @since 2020-01-03
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

}
