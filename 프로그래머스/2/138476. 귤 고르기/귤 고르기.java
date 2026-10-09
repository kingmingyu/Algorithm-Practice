import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 귤의 크기마다 개수를 세고 가장 많은 귤부터 차례대로 배정
        HashMap<Integer, Integer> tMap = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++) {
            tMap.put(tangerine[i], tMap.getOrDefault(tangerine[i], 0) + 1);
        }
        
        Integer[] sortedT = new Integer[tMap.size()];
        int idx = 0;
        for(int t : tMap.values()) {
            sortedT[idx++] = t;
        }
        Arrays.sort(sortedT, Collections.reverseOrder());
        
        int answer = 0;
        for(int i = 0; i < sortedT.length; i++) {
            k -= sortedT[i];
            answer++;
            if(k <= 0) break;
        }
        
        return answer;
    }
}