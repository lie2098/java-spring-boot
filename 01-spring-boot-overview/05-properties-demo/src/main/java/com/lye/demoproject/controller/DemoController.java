package com.lye.demoproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/demo")
public class DemoController {
    @Value("${team.team-name}")
    private String teamName;

    @Value("${team.coach-name}")
    private String coachName;

    @GetMapping("/helloWorld")
    public String helloWord() {
        return "Hello World";
    }

    @GetMapping("/devTools")
    public String autoReloading() {
        return "Application auto reloading...";
    }

    @GetMapping("/getTeamInfo")
    public Object getTeamInfo() {
        Map<String, String> team = new HashMap<>();
        team.put("teamName", teamName);
        team.put("coachName", coachName);

        return team;
    }
}
