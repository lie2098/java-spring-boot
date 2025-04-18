package com.lye.springcoredemo.config;

import com.lye.springcoredemo.service.Coach;
import com.lye.springcoredemo.service.impl.TennisCoachService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkoutConfig {

    @Bean
    public Coach tennisCoach() {
        return new TennisCoachService();
    }

    @Bean("newTennisCoach")
    public Coach newTennisCoach() {
        TennisCoachService tennisCoachService = new TennisCoachService();
        tennisCoachService.setWorkout("Swim 1000 meters for warm up!");

        return tennisCoachService;
    }
}
