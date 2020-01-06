package com.baomidou.test.student.service.impl;

import com.baomidou.test.student.store.domain.Course;
import com.baomidou.test.student.store.mapper.CourseMapper;
import com.baomidou.test.student.service.ICourseService;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
