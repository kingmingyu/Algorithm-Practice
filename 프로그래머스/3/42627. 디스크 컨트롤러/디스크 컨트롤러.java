import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0; // jobCount
        int tick = 0; // 현재 시간
        int jobIdx = 0; // job Index
        
        // 요청 순서대로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 우선순위 큐
        PriorityQueue<int []> queue = new PriorityQueue<>((int[] o1, int[] o2)->{
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            
            return o1[1] - o2[1];
        });
        
        
        while(count < jobs.length) {
            
            // 작업 불러오기
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= tick) {
                queue.offer(jobs[jobIdx++]);
            }
            
            // 큐가 비었다면 다음 시간으로 점프
            if(queue.isEmpty()) {
                tick = jobs[jobIdx][0];
            }
            else {
                // 대기 중인 작업 중에서 가장 짧은 작업 수행
                int[] cur = queue.poll();
                
                answer += (tick - cur[0]) + cur[1];
                
                tick += cur[1];
                count++;
            }
        }
    
        return answer / jobs.length;
    }
}