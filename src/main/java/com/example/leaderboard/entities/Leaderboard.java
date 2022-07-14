package com.example.leaderboard.entities;

import javax.persistence.*;

@Entity
@Table(name="leaderboard_entries")
public class Leaderboard {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_score")
    private String gameScore;

    @Column(name = "player_username")
    private String playerUsername;

    @Column(name = "team_size")
    private String teamSize;

    @Column(name = "created_at")
    private String createdAt;

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setPlayerUsername(String playerUsername) {
        this.playerUsername = playerUsername;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setGameScore(String gameScore) {
        this.gameScore = gameScore;
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getGameScore() {
        return gameScore;
    }

    public String getGameName() {
        return gameName;
    }

    public String getPlayerUsername() {
        return playerUsername;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}

