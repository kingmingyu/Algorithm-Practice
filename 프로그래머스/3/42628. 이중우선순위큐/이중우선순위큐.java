import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++) {
            String[] cur = operations[i].split(" ");
            if(cur[0].equals("I")) {
                int n = Integer.parseInt(cur[1]);
                
                maxQ.offer(n);
                minQ.offer(n);
            }
            else {
                if(cur[1].equals("1")) {
                    if(!maxQ.isEmpty()) {
                        minQ.remove(maxQ.poll());
                    }
                }
                else {
                    if(!minQ.isEmpty()) {
                        maxQ.remove(minQ.poll());    
                    }
                }
            }
        }
        int[] answer = new int[2];
        if(!minQ.isEmpty()) {
            answer[1] = minQ.poll();
        }
        if(!maxQ.isEmpty()) {
            answer[0] = maxQ.poll();
        }
        return answer;
    }
}