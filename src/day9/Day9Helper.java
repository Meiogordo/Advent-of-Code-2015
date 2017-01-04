package day9;

public class Day9Helper {
    
    public String[] getCommands(String input) {
        
        String temp = input;
        String output[] = new String[3]; // 0-dest1 1-dest2 2-dist
        
        output[0] = temp.substring(0, temp.indexOf(" "));
        
        temp = temp.substring(temp.indexOf(" ") + 4);
        
        output[1] = temp.substring(0, temp.indexOf(" "));
        
        temp = temp.substring(temp.indexOf(" ") + 3);
        
        output[2] = temp;
        
        return output;
    }
}
