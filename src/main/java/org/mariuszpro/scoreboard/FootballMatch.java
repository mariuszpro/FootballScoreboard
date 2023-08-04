package org.mariuszpro.scoreboard;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class FootballMatch {
    @Getter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballMatch that = (FootballMatch) o;
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, homeTeam, awayTeam, homeTeamScore, awayTeamScore);
    }
}
