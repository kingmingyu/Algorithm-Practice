import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] a) {
        
        int answer = 0;
        int minl = a[0];
        int[] minr = new int[a.length];
        
        // 오른쪽의 최솟값 배열
        minr[a.length - 1] = a[a.length - 1];
        for(int i = a.length - 2; i >= 0; i--) {
            minr[i] = Math.min(minr[i + 1], a[i]);
        }
        
        for(int i = 0; i < a.length; i++) {
            boolean ls = false;
            boolean rs = false;
            int cur = a[i];
            
            minl = Math.min(cur, minl);
            
            if(cur > minl) ls = true;
            if(cur > minr[i]) rs = true;
            
            if(ls && rs) continue;
            answer++;
        }
        return answer;
    }
}