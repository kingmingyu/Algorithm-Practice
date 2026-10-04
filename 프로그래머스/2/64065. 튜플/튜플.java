import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        String[] sSetArr = s.substring(1, s.length()-1).split("\\{");
        Arrays.sort(sSetArr, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        
        int[] answer = new int[sSetArr.length-1];
        HashSet<Integer> isContains = new HashSet<>();
        int idx = 0;
        for(String arr : sSetArr) {
            if(arr.isEmpty()) continue;
            
            String cur;
            if(arr.charAt(arr.length()-1) == ',') {
                cur = arr.substring(0, arr.length() -2);
            }
            else {
                cur = arr.substring(0, arr.length() -1);
            }
            String[] curArr = cur.split(",");
            for(String i : curArr) {
                int curI = Integer.parseInt(i);
                if(!isContains.contains(curI)) {
                    answer[idx++] = curI;
                    isContains.add(curI);
                    break;
                }
            }
        }
        
        return answer;
    }
}