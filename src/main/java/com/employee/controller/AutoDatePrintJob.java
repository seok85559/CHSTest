package com.employee.controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AutoDatePrintJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//현재 날짜 시간 출력 2024-01-12 09:20:30
		SimpleDateFormat sdf = new SimpleDateFormat("YYY-MM-DD HH:mm:ss");
		System.out.println(sdf.format(Calendar.getInstance().getTime()));
		
	}

}
