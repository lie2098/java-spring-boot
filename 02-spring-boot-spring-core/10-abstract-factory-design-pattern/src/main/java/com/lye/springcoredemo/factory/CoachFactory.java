package com.lye.springcoredemo.factory;

import com.lye.springcoredemo.service.Coach;

import java.nio.channels.spi.AbstractSelectionKey;

public interface CoachFactory {
    Coach getCoach(String coachSport);
}
