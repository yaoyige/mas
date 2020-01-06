package com.baomidou.test.job.config;

import com.baomidou.test.job.DailyJob;
import com.baomidou.test.job.MyCronJob;
import com.baomidou.test.job.MyJob;
import org.quartz.*;
import org.quartz.spi.MutableTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.Calendar.*;
import static org.quartz.DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule;

/**
 * @Auther: yyg
 * @Date: 2020/1/4 09:48
 * @Description:
 */
@Configuration
public class QuartzConfiguration {
    // 使用jobDetail包装job
    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(MyJob.class).withIdentity("myJob").storeDurably().build();
    }

    // 把jobDetail注册到trigger上去
    @Bean
    public Trigger myJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(150000).repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    // 使用jobDetail包装job
    @Bean
    public JobDetail myCronJobDetail() {
        return JobBuilder.newJob(MyCronJob.class).withIdentity("myCronJob").storeDurably().build();
    }

    // 把jobDetail注册到Cron表达式的trigger上去
    @Bean
    public Trigger CronJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 15 10 * * ? *");

        return TriggerBuilder.newTrigger()
                .forJob(myCronJobDetail())
                .withIdentity("myCronJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }



    @Bean
    public JobDetail DailyJobDetail() {
        return JobBuilder.newJob(DailyJob.class).withIdentity("dailyJob").storeDurably().build();
    }

    @Bean
    public Trigger DailyJobTrigger() {


        DailyTimeIntervalScheduleBuilder dailyTimeIntervalScheduleBuilder = dailyTimeIntervalSchedule()
                .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(9, 0)) //第天9：00开始
                .endingDailyAt(TimeOfDay.hourAndMinuteOfDay(16, 0)) //16：00 结束
                .onDaysOfTheWeek(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,SATURDAY) //周一至周五执行
                .withIntervalInHours(1) //每间隔1小时执行一次
                //.withIntervalInSeconds(15)
                .withRepeatCount(100);//最多重复100次（实际执行100+1次）

        return TriggerBuilder.newTrigger()
                .forJob(DailyJobDetail())
                .withIdentity("DailyJobTrigger")
                .withSchedule(dailyTimeIntervalScheduleBuilder)
                .build();

      /*  dailyTimeIntervalSchedule()
                .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(9, 0)) //第天9：00开始
                .endingDailyAfterCount(10) //每天执行10次，这个方法实际上根据 startTimeOfDay+interval*count 算出 endTimeOfDay
                .onDaysOfTheWeek(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY) //周一至周五执行
                .withIntervalInHours(1) //每间隔1小时执行一次
                .build();*/
    }
}
