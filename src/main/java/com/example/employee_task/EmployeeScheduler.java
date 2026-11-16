package com.example.employee_task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmployeeScheduler
{
    private static final Logger log= LoggerFactory.getLogger(EmployeeScheduler.class);
 @Scheduled(fixedRate = 2000)
 public void runTask(){
     log.info("Employee task is running.");

 }
@Scheduled(fixedDelay = 4000)
    public void runDelayMessage(){
     log.info("Employee task is delayed...");
}

}
