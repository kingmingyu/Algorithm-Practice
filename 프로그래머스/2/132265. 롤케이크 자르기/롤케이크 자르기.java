import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] topping) {
        // 전체 토핑 개수를 세기 위한 set
        HashMap<Integer, Integer> curSet1 = new HashMap<>();
        HashMap<Integer, Integer> curSet2 = new HashMap<>();
        for(int i = 0; i < topping.length; i++) {
            curSet1.put(topping[i], curSet1.getOrDefault(topping[i], 0) + 1);
        }
        
        int answer = 0;
        for(int i = 0; i < topping.length; i++) {
            int cur1 = curSet1.getOrDefault(topping[i], 0);
            if(cur1 == 0) continue;
            
            curSet2.put(topping[i], curSet2.getOrDefault(topping[i], 0) + 1);
            curSet1.put(topping[i], cur1 - 1);
            if(curSet1.get(topping[i]) == 0) curSet1.remove(topping[i]);
            
            if(curSet1.size() == curSet2.size()) answer++;
        }
        return answer;
    }
}