import java.util.*;
import java.io.*;
class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) {
            queue.add(w);
        }
        
        while(n > 0) {
            int w = queue.poll();
            w -= 1;
            if(w < 0) {
                break;
            }
            n -= 1;
            queue.add(w);
        }
        long result = 0;
        for(int q : queue) {
            result += (long) q * q;
        }
        return result;
    }
}