package com.service.scheduling;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FileScheduler {
	
	ScheduledExecutorService executorService = Executors
			  .newSingleThreadScheduledExecutor();
	
	public void scheduleAtFixedRate(){
		executorService.scheduleAtFixedRate(new FileProcessor(), 0, 1, TimeUnit.HOURS);	
	}
}
