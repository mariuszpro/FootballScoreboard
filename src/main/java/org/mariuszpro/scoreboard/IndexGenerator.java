package org.mariuszpro.scoreboard;

public class IndexGenerator {
    private static int currentIndex=0;
    public static int getNext(){
        return currentIndex++;
    }
}
