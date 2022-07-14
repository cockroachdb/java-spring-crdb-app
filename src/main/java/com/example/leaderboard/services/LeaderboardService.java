package com.example.leaderboard.services;
import com.example.leaderboard.entities.Leaderboard;
import com.example.leaderboard.repositories.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Configurable
public class LeaderboardService {
    @Autowired
    LeaderboardRepository leaderboardRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertLeaderboard(Leaderboard leaderboardData) {
        entityManager.createNativeQuery(
               "INSERT INTO leaderboard_entries (game_name, game_score, player_username, team_size) VALUES (?,?,?,?)")
               .setParameter(1, leaderboardData.getGameName())
               .setParameter(2, leaderboardData.getGameScore())
               .setParameter(3, leaderboardData.getPlayerUsername())
               .setParameter(4, leaderboardData.getTeamSize())
               .executeUpdate();
    }

    public LeaderboardService() {}

    public List<Leaderboard> getLeaderboard() {
        return leaderboardRepository.findAll();
    }
}

