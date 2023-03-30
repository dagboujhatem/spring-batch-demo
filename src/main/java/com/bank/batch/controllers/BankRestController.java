package com.bank.batch.controllers;

import com.bank.batch.config.BankTransactionItemAnalyticsProcessor;
import com.bank.batch.config.BankTransactionItemProcessor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankRestController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @Autowired
    private BankTransactionItemAnalyticsProcessor analyticsProcessor;

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

    @GetMapping(path = "/analytics")
    public Map<String, Double> analytics(){
        Map<String, Double> response = new HashMap<>();
        response.put("TotalDebit", analyticsProcessor.getTotalDebit());
        response.put("TotalCredit", analyticsProcessor.getTotalCredit());
        return response;
    }


}
