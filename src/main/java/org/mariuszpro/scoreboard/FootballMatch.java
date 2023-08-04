package org.mariuszpro.scoreboard;

import lombok.Getter;

@Getter
public class FootballMatch {

    private final String homeTeam;
    private final String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    public FootballMatch(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }
}
