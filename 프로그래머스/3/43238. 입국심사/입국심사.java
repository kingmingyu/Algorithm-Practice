import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long low = 1;
        long high = (long) times[times.length - 1] * n;
        long answer = 0;
        
        while(low <= high) {
            long mid = (low + high) / 2;
            if(CanFinish(mid, n, times)) {
                answer = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return answer;
    }
    private boolean CanFinish(long time, int n, int[] times) {
        long done = 0;
        for(int t : times) {
            done += time / t;
            if(done >= n) return true;
        }
        return false;
    }
}