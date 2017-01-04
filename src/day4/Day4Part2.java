package day4;

import java.nio.charset.StandardCharsets;

public class Day4Part2 {
    public static void main(String[] args) {
        String input = "bgvyzdsv";
        int testvalue = 0;
        String result = "";
        
        // result = MD5(input);
        // System.out.println("input" + input + "\tresult: " + result);
        
        while (true) {
            
            result = input + testvalue;
            
            System.out.println("result: " + result);
            
            // System.out.println("full: " + MD5(result));
            System.out.println("sub: " + MD5(result).substring(0, 6));
            
            if (MD5(result).substring(0, 6).equals("000000")) {
                System.out.println("Success!!");
                break;
            }
            
            testvalue++;
        }
        
        System.out.println("testvalue final: " + testvalue + "\tresult final: " + result);
    }
    
    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes(StandardCharsets.UTF_8));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
    
}
