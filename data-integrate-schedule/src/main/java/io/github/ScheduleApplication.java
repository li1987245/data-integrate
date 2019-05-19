package io.github;

import io.github.entity.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
@Slf4j
@SpringBootApplication
@RestController
public class ScheduleApplication {
    @RequestMapping("/hello")
    public String home(String name) throws InterruptedException {
        Random ra = new Random();
        Thread.sleep(ra.nextInt(1000));
        log.info(name);
        return "Hello " + name;
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder(ScheduleApplication.class).web(true).run(args);
    }

    public void schedule(){
        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();
            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(SimpleJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(40)
                            .repeatForever())
                    .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

//            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
