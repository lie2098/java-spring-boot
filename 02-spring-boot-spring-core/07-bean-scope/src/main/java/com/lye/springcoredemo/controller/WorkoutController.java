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
    private final Coach anotherBaseballCoach;
    private final Coach basketballCoach;
    private final Coach anotherBasketballCoach;

    @Autowired
    public WorkoutController(@Qualifier("baseballCoachService") Coach baseballCoach,
                             @Qualifier("baseballCoachService") Coach anotherBaseballCoach,
                             @Qualifier("basketballCoachService")Coach basketballCoach,
                             @Qualifier("basketballCoachService") Coach anotherBasketballCoach) {
        System.out.println("Initializing " + getClass().getSimpleName());
        this.baseballCoach = baseballCoach;
        this.anotherBaseballCoach = anotherBaseballCoach;
        this.basketballCoach = basketballCoach;
        this.anotherBasketballCoach = anotherBasketballCoach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout() {
        return baseballCoach.getWorkout();
    }

    @GetMapping("/checkBaseballCoachBean")
    public String checkSingletonBeanScope() {
        return "Compare beans: baseballCoach, anotherBaseballCoach [" + (baseballCoach == anotherBaseballCoach) + "]";
    }

    @GetMapping("/checkBasketballCoachBean")
    public String checkPrototypeBeanScope2() {
        return "Compare beans: basketballCoach, anotherBasketballCoach [" + (basketballCoach == anotherBasketballCoach) + "]";
    }
}
