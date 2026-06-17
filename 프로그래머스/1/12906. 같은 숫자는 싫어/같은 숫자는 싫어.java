import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> queue = new LinkedList<>();
        for(int i : arr) {
            if(!queue.isEmpty()) {
                if(queue.getLast() != i)
                    queue.add(i);
            }
            else{
                queue.add(i);
            }
        }
        int[] answer = new int[queue.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}