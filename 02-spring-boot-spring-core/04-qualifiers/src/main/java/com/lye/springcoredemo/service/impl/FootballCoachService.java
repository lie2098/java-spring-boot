package com.lye.springcoredemo.service.impl;

import com.lye.springcoredemo.service.Coach;
import org.springframework.stereotype.Service;

@Service
public class FootballCoachService implements Coach {
    @Override
    public String getWorkout() {
        return "Football Workout:\n" +
                "- Warm-up: 10 minutes of dynamic stretching (arm circles, leg swings, torso twists), light jogging.\n" +
                "- Position-Specific Drills (30 minutes):\n" +
                "  - Quarterbacks: Throwing mechanics, accuracy drills.\n" +
                "  - Running Backs: Agility drills, blocking technique.\n" +
                "  - Wide Receivers: Route running, catching drills.\n" +
                "  - Offensive/Defensive Line: Blocking/tackling drills, footwork.\n" +
                "  - Defensive Backs: Coverage drills, agility.\n" +
                "- Strength and Conditioning: 30 minutes of weight training focusing on compound lifts (squats, deadlifts, bench press, overhead press) and explosive power exercises.\n" +
                "- Speed and Agility: 20 minutes of sprints, cone drills, and change-of-direction exercises.\n" +
                "- Cool-down: 10 minutes of static stretching.";
    }
}
