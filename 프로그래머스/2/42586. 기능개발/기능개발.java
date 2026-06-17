import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] done = new int[speeds.length];
        
        for(int i = 0; i < speeds.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) {
                done[i] = (100 - progresses[i]) / speeds[i];
            }
            else {
                done[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
        }
        
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        int cnt = 0;
        for(int i : done) {
            if(!queue.isEmpty()) {
                if(queue.getLast() < i) {
                    answerList.add(cnt);
                    queue.poll();
                    queue.add(i);
                    cnt = 1;
                }
                else {
                    cnt++;
                }
            }
            else {
                queue.add(i);
                cnt++;
            }
        }
        answerList.add(cnt);
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}