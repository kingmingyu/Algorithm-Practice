import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        String[] strNums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNums, (o1, o2) -> {
            String o1o2 = o1+o2;
            String o2o1 = o2+o1;
            
            return o2o1.compareTo(o1o2);
        });
        
        for(String s : strNums) {
            sb.append(s);
        }
        
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}