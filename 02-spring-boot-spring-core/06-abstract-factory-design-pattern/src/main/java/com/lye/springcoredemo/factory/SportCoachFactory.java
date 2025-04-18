package com.lye.springcoredemo.factory;

import com.lye.springcoredemo.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SportCoachFactory implements CoachFactory {

    private final Map<String, Coach> coachMap;

    @Autowired
    public SportCoachFactory(Map<String, Coach> coachMap) {
        this.coachMap = coachMap;
    }

    @Override
    public Coach getCoach(String coachSport) {
        return coachMap.get(coachSport);
    }
}
