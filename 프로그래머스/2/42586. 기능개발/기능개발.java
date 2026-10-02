import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < speeds.length; i++) {
            if((100 - progresses[i]) % speeds[i] > 0) {
                queue.offer((100 - progresses[i]) / speeds[i] + 1);
            }
            else {
                queue.offer((100 - progresses[i]) / speeds[i]);
            }
        }
        
        List<Integer> answerList = new ArrayList<>();
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            int cnt = 1;
            while(!queue.isEmpty() && cur >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            answerList.add(cnt);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}