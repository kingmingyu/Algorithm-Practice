import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] scores) {
        int[] targetS = scores[0];
        int sumTarget = targetS[0] + targetS[1];
        
        // 배열 정렬
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1]; // 오름차순
            return o2[0] - o1[0]; // 내림차순
        });
        
        int rank = 1;
        int maxS1 = -1;
        for(int[] score : scores) {
            int s0 = score[0];
            int s1 = score[1];
            
            if(s1 < maxS1) {
                if(targetS[0] == s0 && targetS[1] == s1) return -1;
                continue;
            }
            
            maxS1 = Math.max(maxS1, s1);
            
            // 인호의 순위를 구하기 위해 인호보다 점수가 큰 사람만 체크
            if(sumTarget < s0 + s1) {
                rank++;
            }
        }
        return rank;
    }
}