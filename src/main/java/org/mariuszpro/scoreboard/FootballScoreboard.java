package org.mariuszpro.scoreboard;

import java.util.*;

public class FootballScoreboard {
    private List<FootballMatch> matches;

    public FootballScoreboard() {
        matches = new ArrayList<>();
    }

    /**
     * Adds the match to the scoreboard and
     * returns the index of the match
     * @param homeTeam
     * @param awayTeam
     * @return
     */
    public int startMatch(String homeTeam, String awayTeam) {
        FootballMatch match = new FootballMatch(homeTeam, awayTeam);
        matches.add(match);
        return match.getIndex();
    }

    public void updateScore(int matchIndex, int homeTeamScore, int awayTeamScore) {
        FootballMatch match = findMatchById(matchIndex);
        match.setHomeTeamScore(homeTeamScore);
        match.setAwayTeamScore(awayTeamScore);
    }

    private FootballMatch findMatchById(int matchIndex){
        Optional<FootballMatch> footballMatch = matches.stream().filter(x -> x.getIndex()==matchIndex).findAny();
        if(footballMatch.isEmpty()) throw new NoSuchElementException();
        return footballMatch.get();
    }

    public void finishMatch(int matchIndex) {
        FootballMatch match = findMatchById(matchIndex);
        matches.remove(match);
    }

    public List<FootballMatch> getMatchesOrderedByTotalScoreDesc() {
        List<FootballMatch> sortedMatches = new ArrayList<>(matches);
        Collections.sort(sortedMatches, (match1, match2) -> {
            int scoreComparison = Integer.compare(
                    match2.getHomeTeamScore() + match2.getAwayTeamScore(),
                    match1.getHomeTeamScore() + match1.getAwayTeamScore()
            );
            if (scoreComparison != 0) {
                return scoreComparison;
            }
            // If scores are the same, return the most recently started match first
            return Integer.compare(match2.getIndex(), match1.getIndex());
        });
        return sortedMatches;
    }
}
