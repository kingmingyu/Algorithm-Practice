import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        int answer = 0;
        
        Deque<String> queue = new ArrayDeque<>();
        
        queue.push(cities[0].toLowerCase());
        answer += 5;
        
        for(int i = 1; i < cities.length; i++) {
            String cur = cities[i].toLowerCase();
            if(queue.contains(cur)) {
                queue.remove(cur);
                queue.offer(cur);
                answer++;
                //System.out.println("cache hit: " + cur);
            }
            else {
                queue.offer(cur);
                if(queue.size() > cacheSize) {
                    queue.poll();
                }
                //System.out.println("cache miss: " + cur);
                answer += 5;
            }
        }
        return answer;
    }
}