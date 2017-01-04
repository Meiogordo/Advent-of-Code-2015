package day2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2Helper {
    
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    // Getting string split line into numbers
    public int[] getNumsFromText(String text) {
        int[] a = new int[3]; // 0 is l, 1 is w, 2 is h
        
        int pos1 = 0;
        int pos2 = 0;
        
        pos1 = text.indexOf("x");
        pos2 = text.lastIndexOf("x");
        
        // System.out.println("pos1: " + pos1 + "\npos2: " + pos2 + "\nlength: " + text.length()); //Debug
        
        a[0] = Integer.valueOf(text.substring(0, pos1));
        a[1] = Integer.valueOf(text.substring(pos1 + 1, pos2));
        a[2] = Integer.valueOf(text.substring(pos2 + 1));
        
        // System.out.println("Debugggg: \n0:" + a[0] + "\n1:" + a[1] + "\n2:" + a[2]); //moar debug
        
        return a;
    }
    
    public int getPaperNr(int l, int w, int h) {
        int paperNr = 0;
        
        int smallestSideArea = 0;
        if (l < w) {
            if (w < h)
                smallestSideArea = l * w;
            else
                smallestSideArea = l * h; // old if (w > h)
        }
        
        if (w < l) {
            if (l < h)
                smallestSideArea = w * l;
            else
                smallestSideArea = w * h; // old if (l > h)
        }
        
        if (h < w) {
            if (w < l)
                smallestSideArea = h * w;
            else
                smallestSideArea = h * l; // old if (w > l)
        }
        
        if (l == w) {
            if (w < h)
                smallestSideArea = l * w;
            else
                smallestSideArea = l * h;
        }
        
        if (w == h) {
            if (h < l)
                smallestSideArea = w * h;
            else
                smallestSideArea = w * l;
        }
        
        if (l == h) {
            if (h < w)
                smallestSideArea = l * h;
            else
                smallestSideArea = l * w;
        }
        
        // System.out.println("Deblurg: smallest: " + smallestSideArea);
        paperNr = 2 * l * w + 2 * w * h + 2 * h * l + smallestSideArea;
        
        return paperNr;
    }
    
    public int getPaperNrv2(int l, int w, int h) {
        int paperNr = 0;
        
        int smallestPerimeter = 0;
        if (l < w) {
            if (w < h)
                smallestPerimeter = 2 * l + 2 * w;
            else
                smallestPerimeter = 2 * l + 2 * h;
        }
        
        if (w < l) {
            if (l < h)
                smallestPerimeter = 2 * w + 2 * l;
            else
                smallestPerimeter = 2 * w + 2 * h;
        }
        
        if (h < w) {
            if (w < l)
                smallestPerimeter = 2 * h + 2 * w;
            else
                smallestPerimeter = 2 * h + 2 * l;
        }
        
        if (l == w) {
            if (w < h)
                smallestPerimeter = 2 * l + 2 * w;
            else
                smallestPerimeter = 2 * l + 2 * h;
        }
        
        if (w == h) {
            if (h < l)
                smallestPerimeter = 2 * w + 2 * h;
            else
                smallestPerimeter = 2 * w + 2 * l;
        }
        
        if (l == h) {
            if (h < w)
                smallestPerimeter = 2 * l + 2 * h;
            else
                smallestPerimeter = 2 * l + 2 * w;
        }
        
        System.out.println("Deblurg: smallest: " + smallestPerimeter);
        paperNr = smallestPerimeter + l * w * h;
        
        return paperNr;
    }
}
