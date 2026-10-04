import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> workIdx = new HashMap<>();
        Deque<Integer> workQ = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            workIdx.put(i, priorities[i]);
            workQ.offer(i);
        }
        
        int answer = 1;
        while(!workQ.isEmpty()) {
            int cur = workQ.poll();
            int max = pq.poll();
            if(workIdx.get(cur) == max) {
                if(cur == location) return answer;
                answer++;
            }
            else {
                workQ.offer(cur);
                pq.offer(max);
            }
        }
        return answer;
    }
}