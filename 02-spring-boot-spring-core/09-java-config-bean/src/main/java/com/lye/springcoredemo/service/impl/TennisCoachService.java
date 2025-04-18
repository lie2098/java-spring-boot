package com.lye.springcoredemo.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.lye.springcoredemo.service.Coach;

public class TennisCoachService implements Coach {

    private String workout;

    public TennisCoachService() {
        System.out.println("Initializing " + getClass().getSimpleName());
    }


    @Override
    public String getWorkout() {
        return StringUtil.isNullOrEmpty(workout) ? "Tennis Workout:\n" +
                "- Warm-up: 10 minutes of light cardio (jogging, skipping), dynamic stretching (arm swings, leg swings, torso rotations).\n" +
                "- Groundstroke Practice: 20 minutes of forehand and backhand drills focusing on technique, consistency, and depth.\n" +
                "- Serve Practice: 20 minutes working on serve mechanics, accuracy, and power (first and second serves).\n" +
                "- Volley Practice: 15 minutes of forehand and backhand volleys, focusing on net play and quick reactions.\n" +
                "- Footwork and Agility: 15 minutes of shadow swings with footwork drills, cone drills for lateral movement and speed.\n" +
                "- Match Play/Point Simulation: 20 minutes of playing points or simulating match scenarios to apply skills.\n" +
                "- Cool-down: 10 minutes of static stretching, focusing on shoulders, arms, legs, and back."
                : workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }
}
