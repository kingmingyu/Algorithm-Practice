import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                isFirst = true;
                sb.append(s.charAt(i));
            }
            else {
                if(isFirst == true) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }
                else {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
                isFirst = false;
            }
        }
        
        return sb.toString();
    }
}