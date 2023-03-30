package com.bank.batch.controllers;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @GetMapping(path = "/loadData")
    public BatchStatus loadData() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        while (jobExecution.isRunning())
            System.out.println("loading ....");
        return jobExecution.getStatus();
    }


}
