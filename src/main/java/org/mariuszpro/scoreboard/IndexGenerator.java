package org.mariuszpro.scoreboard;

public class IndexGenerator {
    private static int currentIndex=0;
    public static int getNext(){
        if(currentIndex==Integer.MAX_VALUE){
            currentIndex=-1;
        }
        return currentIndex++;
    }
}
