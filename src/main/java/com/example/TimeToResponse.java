package com.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.sql.Timestamp;
import java.util.Date;

public class TimeToResponse implements JavaDelegate {

    Date date= new Date();

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println(new Timestamp(date.getTime()) + " Application responded");
    }
}

