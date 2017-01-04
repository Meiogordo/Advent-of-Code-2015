package day8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day8 {
    
    public static void main(String[] args) {
        
        Day8Helper Helper = new Day8Helper();
        
        System.out.println(Helper.chrCounterSeen("aaaa tive de abandonar pq o x nao funfa"));
        
    }
    
    // File Getter Construct
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
