package day3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day3Part2 {
    public static void main(String[] args) throws IOException {
        int horizontal = 250, vertical = 250;
        int rhorizontal = 250, rvertical = 250;
        int lim = 500;
        int[][] location = new int[lim][lim];
        int quantos = 0; // Starts at 2 because starting house also gets two
        boolean santaturn = true;
        
        for (int i = 0; i < lim; i++) {
            for (int a = 0; a < lim; a++) {
                location[i][a] = 0;
            }
        }
        
        // Starts at 1 because starting house gets one
        location[horizontal][vertical] += 1;
        location[rhorizontal][rvertical] += 1;
        
        String input = readFile("res/Day 3.txt", StandardCharsets.UTF_8);
        
        for (int i = 0; i < input.length(); i++) {
            
            // Moves Santa
            if (santaturn) {
                if (input.charAt(i) == '^') vertical += 1;
                if (input.charAt(i) == 'v') vertical -= 1;
                if (input.charAt(i) == '>') horizontal += 1;
                if (input.charAt(i) == '<') horizontal -= 1;
                
                System.out.println("vert: " + vertical + "\thoriz: " + horizontal);
            }
            
            // Moves Robosanta
            if (!santaturn) {
                if (input.charAt(i) == '^') rvertical += 1;
                if (input.charAt(i) == 'v') rvertical -= 1;
                if (input.charAt(i) == '>') rhorizontal += 1;
                if (input.charAt(i) == '<') rhorizontal -= 1;
                
                System.out.println("rvert: " + rvertical + "\trhoriz: " + rhorizontal);
            }
            
            System.out.println("bool: " + santaturn + "\t i: " + i);
            
            if (santaturn)
                location[horizontal][vertical] += 1;
            else
                location[rhorizontal][rvertical] += 1;
            
            // Switcher - has to be at end for no repeat
            santaturn = !santaturn;
            
        }
        
        for (int i = 0; i < lim; i++) {
            for (int a = 0; a < lim; a++) {
                if (location[i][a] > 0) {
                    quantos++;
                    System.out.println("coords:  (" + i + "," + a + ")\tvalor do indice: " + location[i][a] + "\tquantos: " + quantos);
                }
            }
        }
        System.out.println("qtsfinal: " + quantos);
    }
    
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
}
