package com.baomidou.test.student.service.impl;

import com.baomidou.test.student.store.domain.Score;
import com.baomidou.test.student.store.mapper.ScoreMapper;
import com.baomidou.test.student.service.IScoreService;
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
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

}
