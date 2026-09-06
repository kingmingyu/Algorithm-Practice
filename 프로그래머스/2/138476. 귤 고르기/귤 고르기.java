import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> tMap = new HashMap<>();
        
        // 크기별로 몇개인지 구별
        for(int i = 0; i < tangerine.length; i++) {
            tMap.put(tangerine[i], tMap.getOrDefault(tangerine[i], 0) + 1);
        }
        
        // 배열로 저장 및 정렬
        Integer[] tKind = new Integer[tMap.size()];
        int i = 0;
        for(int key : tMap.keySet()) {
            tKind[i++] = tMap.get(key);
        }
        Arrays.sort(tKind, Collections.reverseOrder());
        
        // 정답 반환
        int answer = 0;
        for(i = 0; i < tKind.length; i++) {
            k -= tKind[i];
            answer++;
            if(k <= 0) return answer;
        }
        return 0;
    }
}