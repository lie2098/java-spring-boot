package com.lye.aopdemo.service;

import ch.qos.logback.core.util.StringUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
@Service
public class TrafficFortuneService {

    private String fortune;

    public String fortuneToday() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return !StringUtil.isNullOrEmpty(fortune) ? getFortune() : "Today is your lucky day!";
    }

    public void setFortune(String fortune) {
        this.fortune = fortune;
    }

    public String fortuneToday(boolean flag, boolean rethrow) {
        if (flag) {
            throw new RuntimeException("No fortune for you today!");
        }

        return fortuneToday();
    }
}
