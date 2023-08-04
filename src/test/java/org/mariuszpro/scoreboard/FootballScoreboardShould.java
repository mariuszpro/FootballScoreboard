package org.mariuszpro.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballScoreboardShould {
    private FootballScoreboard scoreboard;

    @BeforeEach
    public void setup() {
        scoreboard = new FootballScoreboard();
    }

    @Test
    public void startMatch() {
        scoreboard.startMatch("Team A", "Team B");
        List<FootballMatch> matches = scoreboard.getMatchesOrderedByTotalScoreDesc();
        assertEquals(1, matches.size());
    }

    @Test
    public void updateScore() {
        int matchIndex = scoreboard.startMatch("Team A", "Team B");
        scoreboard.updateScore(matchIndex, 1, 0);

        List<FootballMatch> matches = scoreboard.getMatchesOrderedByTotalScoreDesc();
        assertEquals(1, matches.get(0).getHomeTeamScore());
        assertEquals(0, matches.get(0).getAwayTeamScore());
    }

    @Test
    public void finishMatch() {
        int matchIndex = scoreboard.startMatch("Team A", "Team B");
        scoreboard.finishMatch(matchIndex);

        List<FootballMatch> matches = scoreboard.getMatchesOrderedByTotalScoreDesc();
        assertEquals(0, matches.size());
    }

    @Test
    public void getMatchesInProgressOrderedByScore() {
        int matchIndex = scoreboard.startMatch("Team A", "Team B");
        scoreboard.updateScore(matchIndex, 1, 1);

        int matchIndex2 = scoreboard.startMatch("Team C", "Team D");
        scoreboard.updateScore(matchIndex2, 2, 1);

        List<FootballMatch> matches = scoreboard.getMatchesOrderedByTotalScoreDesc();
        assertEquals(2, matches.size());
        assertEquals("Team C", matches.get(0).getHomeTeam());
        assertEquals("Team D", matches.get(0).getAwayTeam());
        assertEquals("Team A", matches.get(1).getHomeTeam());
        assertEquals("Team B", matches.get(1).getAwayTeam());
    }
}