import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        // 1. 약수 구하기
        int totalArea = brown + yellow;
        int divideInt[] = new int[2000];
        int idx = 0;
        for(int i = 3; i <= Math.sqrt(totalArea); i++) {
            if(totalArea % i == 0) {
                divideInt[idx++] = i;
            }
        }
        
        // 2. 주어진 약수로 조건에 맞는지 검사((가로 - 2) * (세로 - 2) = yellow)
        int[] answer = new int[2];
        for(int i = 0; i < idx; i++) {
            int w = divideInt[i];
            int h = totalArea / divideInt[i];
            
            if((w-2) * (h-2) == yellow) {
                answer[0] = h;
                answer[1] = w;
            }
        }
        
        // 3. 정답 반환
        return answer;
    }
}