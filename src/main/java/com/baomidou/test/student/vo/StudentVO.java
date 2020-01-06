package com.baomidou.test.student.vo;

import com.baomidou.test.student.store.domain.Score;
import com.baomidou.test.student.store.domain.Student;
import lombok.Data;

import java.util.List;

/**
 * @Auther: yyg
 * @Date: 2020/1/3 15:42
 * @Description: 学生查询
 */
@Data
public class StudentVO {

    private Student student;

    private List<Score> scores;
}
