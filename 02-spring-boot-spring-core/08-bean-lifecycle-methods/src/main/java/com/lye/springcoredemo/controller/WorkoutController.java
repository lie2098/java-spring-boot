package com.lye.springcoredemo.controller;

import com.lye.springcoredemo.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final Coach baseballCoach;

    @Autowired
    public WorkoutController(@Qualifier("baseballCoachService") Coach baseballCoach) {
        System.out.println("Initializing " + getClass().getSimpleName());
        this.baseballCoach = baseballCoach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout() {
        return baseballCoach.getWorkout();
    }
}
