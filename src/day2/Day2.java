package day2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Day2 {
    public static void main(String[] args) throws IOException {
        Day2Helper Helper = new Day2Helper();
        
        int[] a = new int[3]; // 0 is l, 1 is w, 2 is h
        int l = 0, w = 0, h = 0;
        int paperTotal = 0;
        
        String input = Day2Helper.readFile("res/Day 2.txt", StandardCharsets.UTF_8);
        
        String inputResult[] = input.split("\\r?\\n");
        
        // System.out.println(input + "\n lol: " + inputResult.length); //texto todo e length do array string
        
        // Testes indiv
        // System.out.println("1,1,10: " + Helper.getPaperNr(1, 1, 10));
        
        for (int i = 0; i < inputResult.length; i++) {
            a = Helper.getNumsFromText(inputResult[i]);
            l = a[0];
            w = a[1];
            h = a[2];
            
            paperTotal += Helper.getPaperNr(l, w, h);
            
            System.out.println("Degub: paperTotal atm: " + paperTotal);
        }
        
        System.out.println(paperTotal);
        
        // Testes indiv
        // System.out.println("2,3,4: " + Helper.getPaperNrv2(2, 3, 4));
        
        paperTotal = 0; // NÃO APAGUES ISTO !!!!!!
        
        for (int i = 0; i < inputResult.length; i++) {
            a = Helper.getNumsFromText(inputResult[i]);
            l = a[0];
            w = a[1];
            h = a[2];
            
            paperTotal += Helper.getPaperNrv2(l, w, h);
            
            // System.out.println("Degub: paperTotal atmv2: " + paperTotal);
        }
        
        System.out.println(paperTotal);
        
    }
}
