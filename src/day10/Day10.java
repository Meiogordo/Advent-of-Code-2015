package day10;

public class Day10 {
    
    public static String getNext(String input) {
        
        String result = "";
        char ci = ' ', ciminus1 = ' '; // chars at i and i minus 1, respectively
        int followup = 1; // counts repeated characters in sequence -> inited at 1 because it only counts starting from 2 (i = i-1)
        
        for (int i = 1; i < input.length(); i++) {
            
            ci = input.charAt(i);
            ciminus1 = input.charAt(i - 1);
            
            // System.out.println("i: " + ci + " ci-1: " + ciminus1);
            
            if (ci == ciminus1) {
                followup++; // +1 is repeated, if it is repeated
                // System.out.println("I like it!: " + followup);
            } else {
                result = result + "" + followup + ciminus1; // adds to result with the nr of times repeated and the character
                // System.out.println("res in class: " + result);
                followup = 1;
            }
        }
        // to account for the end of the string lel
        result = result + "" + followup + input.charAt(input.length() - 1);
        return result;
    }
    
    public static void main(String[] args) {
        String input = "111221";
        String result = "";
        String caganisso = "3113322113";
        
        for (int i = 1; i <= 50; i++) { // 40 part 1 50 part 2
            caganisso = getNext(caganisso);
            System.out.println("i:" + i);
        }
        
        // result = getNext(input);
        //
        // System.out.println("input: " + input);
        // System.out.println("result: " + result);
        
        System.out.println("caga nisso bro: " + caganisso.length());
        
    }
} // Part 1 under 5 mins prolly, part 2 over 30 already (start time 00:48:08 to 01:39++ and didn't pass 47)