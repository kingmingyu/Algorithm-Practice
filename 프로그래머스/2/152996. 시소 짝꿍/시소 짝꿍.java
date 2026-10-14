import java.util.*;

class Solution {
    static int[] wG;
    public long solution(int[] weights) {
        HashMap<Integer, Integer> wMap = new HashMap<>();
        
        for(int i = 0; i < weights.length; i++) {
            wMap.put(weights[i], wMap.getOrDefault(weights[i], 0) + 1);
        }
        long answer = 0;
        for(int k : wMap.keySet()) {
            long wCnt = wMap.get(k);
            // 몸무게가 같은 경우
            answer += wCnt * (wCnt - 1) / 2;
            
            // 몸무게가 2배인 경우
            if(wMap.getOrDefault(k * 2, 0) != 0) {
                answer += (long)wMap.get(k*2) * wCnt;
            }
            // 몸무게가 3/2인 경우
            if(k % 2 == 0 && wMap.getOrDefault(k / 2 * 3, 0) != 0) {
                answer += (long)wMap.get(k / 2 * 3) * wCnt;
            }
            // 몸무게가 4/3인 경우
            if(k % 3 == 0 && wMap.getOrDefault(k / 3 * 4, 0) != 0) {
                answer += (long)wMap.get(k /3 *4) * wCnt;
            }
            //System.out.println("cur: " + k + "/ answer: " + answer);
        }
        
        return answer;
    }
}