package org.mariuszpro.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FootballScoreboardShould {
    private FootballScoreboard scoreboard;

    @BeforeEach
    public void setup() {
        scoreboard = new FootballScoreboard();
    }

    @Test
    public void startMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        List<FootballMatch> matches = scoreboard.getMatchesOrderedByTotalScoreDesc();
        assertEquals(1, matches.size());
    }

    @Test
    public void updateScore() {
        addMatchToScoreboard("Mexico", "Canada",1,0);
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
        int mexicoCanadaIndex = addMatchToScoreboard("Mexico", "Canada",0,5);
        int spainBrazilIndex = addMatchToScoreboard("Spain","Brazil",10,2);
        int germanyFranceIndex = addMatchToScoreboard("Germany","France",2,2);
        int uruguayItalyIndex = addMatchToScoreboard("Uruguay","Italy",6,6);
        int argentinaAustraliaIndex = addMatchToScoreboard("Argentina","Australia",3,1);

        List<FootballMatch> matches = scoreboard.getMatchesOrderedByTotalScoreDesc();
        assertEquals(5, matches.size());
        assertEquals(uruguayItalyIndex, matches.get(0).getIndex());
        assertEquals(spainBrazilIndex, matches.get(1).getIndex());
        assertEquals(mexicoCanadaIndex, matches.get(2).getIndex());
        assertEquals(argentinaAustraliaIndex, matches.get(3).getIndex());
        assertEquals(germanyFranceIndex, matches.get(4).getIndex());
    }

    @Test
    public void throwsExceptionWhenTheMatchDoesNotExist(){
        int matchIndex = scoreboard.startMatch("Mexico", "Canada");
        assertThrows(NoSuchElementException.class, () -> {
            scoreboard.updateScore(matchIndex+1,1,1);
        });
    }

    private int addMatchToScoreboard(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore){
        int matchIndex = scoreboard.startMatch(homeTeam, awayTeam);
        scoreboard.updateScore(matchIndex, homeTeamScore, awayTeamScore);
        return matchIndex;
    }
}