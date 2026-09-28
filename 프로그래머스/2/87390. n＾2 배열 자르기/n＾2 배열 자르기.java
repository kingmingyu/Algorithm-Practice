import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int)(right - left + 1)];
        int idx = 0;
        int ans = 0;
        for(long i = left; i <= right; i++) {
            int r = (int)(i / n), c = (int)(i % n);
            
            ans = (int)(i % n) + 1;
            if((r+1) > ans) ans += r+1 - ans;
            //System.out.println("r: " + r + "/ c: " + c + "/ ans: " + ans);
            
            answer[idx++] = ans;
        }
        
        return answer;
    }
}