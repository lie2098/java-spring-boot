package com.lye.springcoredemo.controller;

import com.lye.springcoredemo.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final Coach baseballCoachService;

    @Autowired
    public WorkoutController(Coach baseballCoachService) {
        this.baseballCoachService = baseballCoachService;
    }

    @GetMapping("/getWorkout")
    public Object getWorkout() {
        return baseballCoachService.getWorkout();
    }
}
