package com.baomidou.test.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.test.common.util.JSONResult;
import com.baomidou.test.student.store.domain.Score;
import com.baomidou.test.student.store.domain.Student;
import com.baomidou.test.student.store.mapper.ScoreMapper;
import com.baomidou.test.student.store.mapper.StudentMapper;
import com.baomidou.test.student.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.test.student.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yaoyige
 * @since 2020-01-03
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public JSONResult getListByStuId(String sId) {
        StudentVO studentVO = new StudentVO();
        //根据id去查询对应的学生信息
        Student student =  studentMapper.selectOne(new QueryWrapper<Student>().eq("s_id",sId));
        studentVO.setStudent(student);
        QueryWrapper<Score> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s_id",sId);
        List<Score> scores = scoreMapper.selectList(queryWrapper);
        studentVO.setScores(scores);
        return JSONResult.ok(studentVO);
    }
}
