import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 큐[우선순위, 인덱스]
        Queue<int[]> queue = new ArrayDeque<>();
        // 우선 순위
        List<Integer> prio = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            // 큐에 삽입
            queue.offer(new int [] {priorities[i], i});
            // 우선순위 삽입
            prio.add(priorities[i]);
        }
        // 우선 순위 정렬
        Collections.sort(prio, Collections.reverseOrder());
        // 큐가 비어있지 않은 동안
        while(!queue.isEmpty()) {
            // 지금 실행할 프로세스
            int[] cur = queue.poll();
            // 우선 순위가 가장 높다면
            if(prio.get(0) == cur[0]) {
                // 우선 순위 소모
                prio.remove(0);
                // 프로세스 증가
                answer++;
                // 만약 목표한 프로세스 인덱스라면
                if(cur[1] == location) {
                    // 종료
                    return answer;
                }
            }
            else{
                queue.offer(cur);
            }
        }
        return answer;
    }
}