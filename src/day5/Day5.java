package day5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Day5 {
    public static void main(String[] args) throws IOException {
        
        Day5Helper Helper = new Day5Helper();
        boolean isNice = false;
        int nice = 0, naughty = 0;
        
        String input = Day5Helper.readFile("res/Day 5.txt", StandardCharsets.UTF_8);
        
        String inputResult[] = input.split("\\r?\\n"); // Splitting at line break
        
        // // Individual tests
        // if (Helper.checkNicev2("ieodomkazucvgmuy"))
        // System.out.println("nice");
        // else
        // System.out.println("naughty");
        
        for (int i = 0; i < inputResult.length; i++) {
            
            isNice = Helper.checkNicev2(inputResult[i]);
            
            if (isNice) {
                nice++;
                System.out.println("nice");
            } else {
                System.out.println("naughty");
                naughty++;
            }
        }
        System.out.println("nice: " + nice + "\tnaughty: " + naughty + "\ntotal: " + (naughty + nice));
    }
}
