import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> wMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wMap.put(want[i], number[i]);
        }
        
        // 처음 세팅
        int answer = 0;
        HashMap<String, Integer> curMap = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            curMap.put(discount[i], curMap.getOrDefault(discount[i], 0) + 1);
        }
        if(check(curMap, wMap)) {
            answer++;
        }
        
        for(int i = 0; i < discount.length - 10; i++) {
            if(curMap.get(discount[i]) == 1) {
                curMap.remove(discount[i]);
            }
            else {
                curMap.put(discount[i], curMap.get(discount[i]) - 1);
            }
            curMap.put(discount[i+10], curMap.getOrDefault(discount[i+10], 0)+1);
            
            if(check(curMap, wMap)) {
                answer++;
            }
        }
        
        return answer;
    }
    static boolean check(HashMap cur, HashMap want) {
        for(Object key : cur.keySet()) {
            if(cur.getOrDefault(key, 0) != want.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }
}