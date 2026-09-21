import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        
        String[] sArr = s.substring(1, s.length()-1).split("\\{");
        for(String a : sArr) {
            if(a.equals("")) continue;
            String aArr[] = a.split(",");
            int intArr[] = new int[aArr.length];
            int i = 0;
            for(String aa : aArr) {
                if(aa.charAt(aa.length()-1) == '}') 
                    intArr[i++] = Integer.parseInt(aa.substring(0, aa.length() - 1));
                else 
                    intArr[i++] = Integer.parseInt(aa);
            }
            map.put(aArr.length, intArr);
        }
        
        int[] answer = new int[map.size()];
        HashSet<Integer> used = new HashSet<>();
        int i = 0;
        for(int[] arr : map.values()) {
            for(int n : arr) {
                if(!used.contains(n)) {
                    answer[i++] = n;
                    used.add(n);
                }
            }
        }
        return answer;
    }
}