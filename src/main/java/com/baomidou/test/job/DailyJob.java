package com.baomidou.test.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Auther: yyg
 * @Date: 2020/1/4 11:08
 * @Description:
 */
public class DailyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("开始执行。。"+new Date());
    }
}
