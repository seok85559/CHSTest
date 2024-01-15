package com.employee.controller;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TestCronTrigger {
	//크론식 - 원하는 주기를 설정하는 문자열
	private String timer;
	//실제 작업을 할 클래스 --> Job을 상속 받는 클래스
	private Class<? extends Job> job;
	//Job을 등록할 스케줄러
	private Scheduler scheduler;
	
	public TestCronTrigger(String timer, Class<? extends Job> job) {
		super();
		this.timer = timer;
		this.job = job;
	}
	
	//스케줄러에 job을 등록
	public void triggerJob() {
		SchedulerFactory factory = new StdSchedulerFactory();
		JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(job.getName(),"group").build();
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger","group")
				.withSchedule(CronScheduleBuilder.cronSchedule(timer)).build();
		
		try {
			scheduler = factory.getScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, cronTrigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
