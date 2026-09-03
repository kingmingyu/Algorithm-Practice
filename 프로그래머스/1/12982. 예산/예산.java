import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] d, int budget) {
        // 배열 정렬
        Arrays.sort(d);
        
        // 앞에서부터 예산 차감
        int answer = 0;
        for(int i = 0; i < d.length; i++) {
            if(budget - d[i] >= 0) {
                budget -= d[i];
                answer++;
            }
            else {
                break;
            }
        }
        
        // 정답 반환
        return answer;
    }
}