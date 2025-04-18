package com.lye.springcoredemo.controller;

import com.lye.springcoredemo.factory.CoachFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final CoachFactory coachFactory;

    @Value("${sports.coach.baseball}")
    private String baseballCoach;

    @Value("${sports.coach.basketball}")
    private String basketballCoach;

    @Value("${sports.coach.football}")
    private String footballCoach;

    @Value("${sports.coach.tennis}")
    private String tennisCoach;

    public WorkoutController(CoachFactory coachFactory) {
        this.coachFactory = coachFactory;
    }

    @GetMapping("/baseball/getWorkout")
    public String getBaseballWorkout() {
        return coachFactory.getCoach(baseballCoach).getWorkout();
    }

    @GetMapping("/basketball/getWorkout")
    public String getBasketballWorkout() {
        return coachFactory.getCoach(basketballCoach).getWorkout();
    }

    @GetMapping("/football/getWorkout")
    public String getFootballWorkout() {
        return coachFactory.getCoach(footballCoach).getWorkout();
    }

    @GetMapping("/tennis/getWorkout")
    public String getTennisWorkout() {
        return coachFactory.getCoach(tennisCoach).getWorkout();
    }
}
