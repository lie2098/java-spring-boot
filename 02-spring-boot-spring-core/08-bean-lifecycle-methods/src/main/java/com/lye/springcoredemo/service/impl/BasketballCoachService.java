package com.lye.springcoredemo.service.impl;

import com.lye.springcoredemo.service.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class BasketballCoachService implements Coach {

    public BasketballCoachService() {
        System.out.println("Initializing " + getClass().getSimpleName());
    }

    @PostConstruct
    public void init() {
        System.out.println("executing init() -- " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("executing destroy() -- " + getClass().getSimpleName());
    }

    @Override
    public String getWorkout() {
        return "Basketball Workout:\n" +
                "- Warm-up: 10 minutes of light cardio (jogging, jumping jacks), dynamic stretching (arm circles, leg swings).\n" +
                "- Dribbling Drills: 15 minutes of various dribbling exercises (crossovers, behind-the-back, figure eights).\n" +
                "- Shooting Practice: 20 minutes focusing on different shot types (layups, jump shots, free throws) with proper form.\n" +
                "- Passing Drills: 15 minutes of chest passes, bounce passes, and overhead passes with a partner.\n" +
                "- Agility and Footwork: 15 minutes of cone drills, ladder drills, and lateral shuffling.\n" +
                "- Strength and Conditioning: 20 minutes of bodyweight exercises (squats, lunges, push-ups, planks) or light weight training.\n" +
                "- Cool-down: 10 minutes of static stretching.";
    }
}
