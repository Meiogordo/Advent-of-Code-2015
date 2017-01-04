package day6;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day6Helper {
    
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    // Parses strings to get two nums into array, basically getting the pos from the string
    public int[] numParser(String input) {
        int[] output = new int[2];
        
        output[0] = Integer.parseInt(input.substring(0, input.indexOf(",")));
        System.out.println("output 0: " + output[0]);
        
        output[1] = Integer.parseInt(input.substring(input.indexOf(",") + 1));
        System.out.println("output 1: " + output[1]);
        
        return output;
    }
    
    // Parses line into string array to carry out commands
    public String[] parser(String input) {
        // 0 - instruction
        // 1 - (horizstart,horizend)
        // 2 - (vertstart,vertend)
        
        String[] output = new String[3];
        
        if (input.contains("turn on"))
            output[0] = "turn on";
        else if (input.contains("turn off"))
            output[0] = "turn off";
        else if (input.contains("toggle"))
            output[0] = "toggle";
        else
            System.out.println("Invalid argument");
        
        output[1] = input.substring(output[0].length() + 1, input.indexOf("through") - 1);
        System.out.println("Debug coords inciais: " + output[1]);
        
        output[2] = input.substring(input.indexOf("through") + 8);
        System.out.println("Debug coords finais: " + output[2]);
        
        return output;
    }
}
