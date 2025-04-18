package com.lye.springcoredemo.service.impl;

import com.lye.springcoredemo.service.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoachService implements Coach {

    @Override
    public String getWorkout() {
        return "Spend 30 minutes batting practice in the cage.\r\n" +
                "Practice pitching for 20 minutes, focusing on accuracy.\r\n" +
                "Do 15 minutes of infield/outfield drills.\r\n" +
                "Engage in a 10-minute base running drill.\r\n" +
                "Finish with 15 minutes of strength and conditioning (e.g., squats, lunges, push-ups).";
    }
}
