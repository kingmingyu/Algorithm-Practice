import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, int s) {
        
        int[] answer = new int[n];
        
        // 만들 수 없는 경우
        if(n > s) {
            return new int[] {-1};
        }
        
        int base = s/n;
        for(int i = 0; i < n; i++) {
            answer[i] = base;
        }
        
        int r = s % n;
        for(int i = 0; i < r; i++) {
            answer[n - i - 1] += 1;
        }
        
        return answer;
    }
}