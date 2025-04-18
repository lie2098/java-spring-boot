package com.lye.springcoredemo.service.impl;

import com.lye.springcoredemo.service.Coach;
import com.lye.utils.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseballCoachService implements Coach {

    private final ConversionUtil util;

    @Autowired
    public BaseballCoachService(ConversionUtil util) {
        this.util = util;
    }

    @Override
    public Object getWorkout() {
        String workOut = "Spend 30 minutes batting practice in the cage.\r\n" +
                "Practice pitching for 20 minutes, focusing on accuracy.\r\n" +
                "Do 15 minutes of infield/outfield drills.\r\n" +
                "Engage in a 10-minute base running drill.\r\n" +
                "Finish with 15 minutes of strength and conditioning (e.g., squats, lunges, push-ups).";
        return util.stringToObject(workOut, "\r\n");
    }
}
