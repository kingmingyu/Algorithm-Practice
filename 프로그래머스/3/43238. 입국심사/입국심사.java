import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long low = 0;
        long high = (long)times[times.length - 1] * n;
        long answer = high;
        
        while(high >= low) {
            long mid = (low + high) / 2;
            
            if(Check(mid, n, times)) {
                answer = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return answer;
    }
    public static boolean Check(long time, int n, int[] times) {
        long cnt = 0;
        for(int t : times) {
            cnt += time / t;
            if(cnt >= n) {
                return true;
            }
        }
        return false;
    }
}