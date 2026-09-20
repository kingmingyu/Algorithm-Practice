import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        // 보정 값
        int lastCamera = -30001;
        
        int answer = 0;
        
        for(int[] cur : routes) {
            if(cur[0] > lastCamera) {
                answer++;
                lastCamera = cur[1];
            }
        }
        
        
        return answer;
    }
}