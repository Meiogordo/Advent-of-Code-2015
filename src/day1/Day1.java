package day1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day1 {
    
    // Main, destroyer of worlds
    public static void main(String[] args) throws IOException {
        String input = readFile("res/Day 1.txt", StandardCharsets.UTF_8);
        
        int floor = 0;
        
        System.out.println(input + "\nlol: " + input.length());
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') floor++;
            if (input.charAt(i) == ')') floor--;
            
            if (floor == -1) System.out.println("lelele: " + (i + 1));
        }
        
        System.out.println(floor);
    }
    
    // File Getter Construct
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
