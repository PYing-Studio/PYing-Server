package com.sysu.crawler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sysu.utils.DateUtil;

//@Component
public class MyTask {
	
//    @Scheduled(cron="0/5 * * * * ? ")//5秒一次; 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点 
    public void task(){
    	DBUtil.systemOutToFile();
    	System.out.println(DateUtil.getCurrrentDateString());
    }
}
