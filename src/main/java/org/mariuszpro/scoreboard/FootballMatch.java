package org.mariuszpro.scoreboard;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class FootballMatch {
    private final int index;
    private final String homeTeam;
    private final String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    public FootballMatch(String homeTeam, String awayTeam) {
        this.index = IndexGenerator.getNext();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }
}
