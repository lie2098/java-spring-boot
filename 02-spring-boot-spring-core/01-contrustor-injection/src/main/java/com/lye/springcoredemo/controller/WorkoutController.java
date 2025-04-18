package com.lye.springcoredemo.controller;

import com.lye.springcoredemo.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final Coach coach;

    @Autowired
    public WorkoutController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout() {
        return coach.getWorkout();
    }
}
