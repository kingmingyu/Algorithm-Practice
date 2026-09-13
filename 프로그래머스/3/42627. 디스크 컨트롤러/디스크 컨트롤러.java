import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 도착 시간 순서로 정렬
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        // 작업 시간이 작은 순서로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int t = 0;
        int answer = 0;
        int i = 0;
        while(i < jobs.length || !pq.isEmpty()) {
            while(i < jobs.length && jobs[i][0] <= t) {
                pq.offer(jobs[i++]);
            }
            if(!pq.isEmpty()) {
                int[] cur = pq.poll();
                t += cur[1];
                answer += t - cur[0];
            }
            else {
                t = jobs[i][0];
            }
        }
        
        return answer / jobs.length;
    }
}