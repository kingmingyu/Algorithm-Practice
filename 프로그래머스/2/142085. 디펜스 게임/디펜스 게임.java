import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++) {
            int cur = enemy[i];
            
            if(n - cur >= 0) {
                n -= cur;
                queue.offer(cur);
            }
            else {
                if(k > 0) {
                    n -= cur;
                    queue.offer(cur);
                    k -= 1;
                    n += queue.poll();
                }
                else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}