package day9;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day9 {
    
    public static void main(String[] args) throws IOException {
        
        Day9Helper Helper = new Day9Helper();
        
        String inputraw = readFile("res/Day 9.txt", StandardCharsets.UTF_8);
        
        String input[] = inputraw.split("\\r?\\n");
        
        String testput[] = { "London to Dublin = 464", "London to Belfast = 518", "Dublin to Belfast = 141" };
        
        String outin[] = new String[3];
        
        for (int i = 0; i < testput.length; i++) {
            outin = Helper.getCommands(testput[i]);
            for (int j = 0; j < outin.length; j++) {
                System.out.println(outin[j]);
            }
        }
    }
    
    // File Getter Construct
    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
