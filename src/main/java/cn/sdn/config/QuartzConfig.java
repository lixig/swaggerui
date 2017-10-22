package cn.sdn.config;

import cn.sdn.quartz.SDNDataCollect;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.naming.NamingEnumeration;

/**
 * Created by L on 2017/10/15.
 */
@Configuration
public class QuartzConfig {
    /**
     * attention
     * details:配置定时任务
     */

    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(SDNDataCollect task) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        /*
         *  是否并发执行
         *  例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了，
         *  如果此处为true，则下一个任务会执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行
         */
        jobDetail.setConcurrent(false);

        jobDetail.setName("srd-chhliu");// 设置任务的名字
        jobDetail.setGroup("srd");// 设置任务的分组，这些属性都可以存储在数据库中，在多任务的时候使用

        /*
         * 为需要执行的实体类对应的对象
         */
        jobDetail.setTargetObject(task);

        /*
         * sayHello为需要执行的方法
         * 通过这几个配置，告诉JobDetailFactoryBean我们需要执行定时执行ScheduleTask类中的sayHello方法
         */
        jobDetail.setTargetMethod("uploadSDNData");
        // jobDetail.setTargetMethod("uploadSDNData2");
        return jobDetail;
    }

    /**
     * attention:
     * Details：配置定时任务的触发器，也就是什么时候触发执行定时任务
     */
    @Bean(name = "jobTigger")
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(jobDetail.getObject());
        tigger.setCronExpression("0/5 * * * * ? *");  //cron时间表达式 0秒开始每五秒执行一次
        tigger.setName("srd-chhliu");

        return tigger;
    }

    /**
     * attention:
     * Details：定义quartz调度工厂
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger cronJobTrigger) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //用于quartz集群quartzScheduler启动时更新已存在的Job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        //延时启动，应用启动10秒后
        schedulerFactoryBean.setStartupDelay(1);

        //注册触发器
        schedulerFactoryBean.setTriggers(cronJobTrigger);

        return schedulerFactoryBean;


    }
}

