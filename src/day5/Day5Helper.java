package day5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day5Helper {
    
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    public boolean checkNice(String input) {
        
        boolean vwl3 = false;
        boolean twoTimesLetter = false;
        boolean noSpecificString = false;
        
        String checkvowels = "aeiou";
        int nrvowels = 0;
        
        //
        //
        //
        
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                twoTimesLetter = true;
                System.out.println("double consecutive char at: " + i + "," + (i + 1) + "\t being char " + input.charAt(i));// debug obv
                break;
            }
        }
        
        //
        //
        //
        
        // Checking vowels
        for (int a = 0; a < input.length(); a++) {
            for (int i = 0; i < checkvowels.length(); i++) {
                if (input.charAt(a) == checkvowels.charAt(i)) nrvowels += 1;
            }
        }
        // Final vowel check
        if (nrvowels >= 3)
            vwl3 = true;
        else
            vwl3 = false;
        
        //
        //
        //
        
        // Naughty string contained check
        if (input.contains("ab") || input.contains("cd") || input.contains("pq") || input.contains("xy"))
            noSpecificString = false;
        else
            noSpecificString = true;
        
        //
        //
        //
        
        // Return check
        if (vwl3 && twoTimesLetter && noSpecificString)
            return true;
        else
            return false;
    }
    
    public boolean checkNicev2(String input) {
        boolean lettersPairs = false;
        boolean lettersCrossed = false;
        
        String tempstring = "";
        char tempchar = ' ';
        
        //
        //
        //
        
        for (int i = 0; i < input.length() - 2; i++) {
            
            // Equal
            if (input.charAt(i) == input.charAt(i + 1)) {
                tempchar = input.charAt(i);
                if (input.substring(i + 2).contains("" + tempchar + tempchar)) {
                    if (!input.substring(i + 2).contains("" + tempchar + tempchar + tempchar)) {
                        lettersPairs = true;
                        System.out.println("O par: " + ("" + tempchar + tempchar) + " repete-se sem se sobrepor");
                        break;
                    } else
                        lettersPairs = false;
                }
                
            } else {
                // Non-equal
                tempstring = input.substring(i, i + 2);
                if (input.substring(i + 2).contains(tempstring)) {
                    System.out.println("contém: " + tempstring + " repetido");
                    lettersPairs = true;
                    break;
                }
            }
        }
        
        //
        //
        //
        
        // Check for crisscrossing (xyx)
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) == input.charAt(i + 2)) {
                lettersCrossed = true;
                System.out.println("sucesso em i: " + i + "\tcom string: " + input.substring(i, i + 3));
                break;
            }
        }
        
        //
        //
        //
        
        // Return check
        if (lettersPairs && lettersCrossed)
            return true;
        else
            return false;
    }
}
