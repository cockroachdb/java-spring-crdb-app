package com.example.leaderboard.controller;
import com.example.leaderboard.entities.Leaderboard;
import com.example.leaderboard.services.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

@Controller
public class LeaderboardController {
    @Autowired
    LeaderboardService leaderboardService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("entries", leaderboardService.getLeaderboard());

        return "home";
    }

    @GetMapping("/status")
    public String status() {
        return "status";
    }

    @GetMapping("/create-entry")
    public String getEntries(@ModelAttribute Leaderboard leaderboard, Model model) {
        model.addAttribute("leaderboard", new Leaderboard());

        return "create-entry";
    }

    @PostMapping("/create-entry")
    public String submitEntryData(Leaderboard leaderboardData, Model model) {
        model.addAttribute("leaderboard", leaderboardData);
        leaderboardService.insertLeaderboard(leaderboardData);

        return "redirect:/";
    }
}

