import java.util.*;
import java.io.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>(Collections.reverseOrder());
        
        long check = 0;
        for(int w : works) {
            check += w;
            pq.offer(w);
        }
        
        if(check <= n) return 0;
        
        while(n > 0) {
            int cur = pq.poll();
            cur -= 1;
            n -= 1;
            pq.offer(cur);
        }
        
        long answer = 0;
        for(int w : pq) {
            answer += w * w;
        }
        return answer;
    }
}