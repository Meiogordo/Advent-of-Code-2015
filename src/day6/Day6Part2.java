package day6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Day6Part2 {
    public static void main(String[] args) throws IOException {
        
        Day6Helper Helper = new Day6Helper();
        int[][] lights = new int[1000][1000];
        String[] carrier = new String[3]; // String to carry out commands, 0 - command, 1 - startPos, 2 - endPos
        int[] startPos = new int[2]; // starting position, 0 - x 1 - y
        int[] endPos = new int[2]; // ending position, 0 - x 1 - y
        int brightness = 0; // brightness counter
        
        // Init light grid off - just to make sure
        for (int i = 0; i < 1000; i++) {
            for (int a = 0; a < 1000; a++) {
                lights[i][a] = 0;
            }
        }
        
        String input = Day6Helper.readFile("res/Day 6.txt", StandardCharsets.UTF_8);
        String inputResult[] = input.split("\\r?\\n");
        
        for (int i = 0; i < inputResult.length; i++) {
            carrier = Helper.parser(inputResult[i]);
            System.out.println(carrier[0] + "\n" + carrier[1] + "\n" + carrier[2]);
            
            startPos = Helper.numParser(carrier[1]);
            endPos = Helper.numParser(carrier[2]);
            
            if (carrier[0].equals("turn on")) {
                
                for (int x = startPos[0]; x <= endPos[0]; x++) {
                    for (int y = startPos[1]; y <= endPos[1]; y++) {
                        lights[x][y]++; // turns on lights from startPos(x,y) to endPos(x,y)
                    }
                }
                
            }
            
            if (carrier[0].equals("turn off")) {
                
                for (int x = startPos[0]; x <= endPos[0]; x++) {
                    for (int y = startPos[1]; y <= endPos[1]; y++) {
                        if (lights[x][y] > 0) {
                            lights[x][y]--; // turns off lights from startPos(x,y) to endPos(x,y)
                        }
                    }
                }
                
            }
            
            if (carrier[0].equals("toggle")) {
                
                for (int x = startPos[0]; x <= endPos[0]; x++) {
                    for (int y = startPos[1]; y <= endPos[1]; y++) {
                        lights[x][y] += 2; // toggles lights from startPos(x,y) to endPos(x,y)
                    }
                }
                
            }
        }
        
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                brightness += lights[x][y];
            }
        }
        
        System.out.println("final brightness: " + brightness);
    }
    
}
