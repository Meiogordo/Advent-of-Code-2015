package day3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day3 {
    public static void main(String[] args) throws IOException {
        int horizontal = 250, vertical = 250;
        int lim = 500;
        int[][] location = new int[lim][lim];
        int quantos = 0;
        
        for (int i = 0; i < lim; i++) {
            for (int a = 0; a < lim; a++) {
                location[i][a] = 0;
            }
        }
        
        location[horizontal][vertical] = 1; // Starts at 1 because starting house gets one
        
        String input = readFile("res/Day 3.txt", StandardCharsets.UTF_8);
        
        for (int i = 0; i < input.length(); i++) {
            // Moves
            if (input.charAt(i) == '^') vertical += 1;
            if (input.charAt(i) == 'v') vertical -= 1;
            if (input.charAt(i) == '>') horizontal += 1;
            if (input.charAt(i) == '<') horizontal -= 1;
            
            System.out.println("vert: " + vertical + "\thoriz: " + horizontal);
            
            location[horizontal][vertical] += 1; // Deliver
        }
        
        for (int i = 0; i < lim; i++) {
            for (int a = 0; a < lim; a++) {
                if (location[i][a] >= 1) {
                    quantos++;
                    System.out.println("coords:  (" + i + "," + a + ")\tquantos: " + quantos);
                }
            }
        }
        System.out.println("quantos final: " + quantos);
    }
    
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
