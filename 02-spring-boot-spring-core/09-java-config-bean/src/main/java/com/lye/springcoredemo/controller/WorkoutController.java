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

    private final Coach tennisCoach;
    private final Coach newTennisCoach;

    @Autowired
    public WorkoutController(Coach tennisCoach,
                             Coach newTennisCoach) {
        System.out.println("Initializing " + getClass().getSimpleName());
        this.tennisCoach = tennisCoach;
        this.newTennisCoach = newTennisCoach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout() {
        return tennisCoach.getWorkout();
    }

    @GetMapping("/getNewWorkout")
    public String getNewWorkout() {
        return newTennisCoach.getWorkout();
    }
}
