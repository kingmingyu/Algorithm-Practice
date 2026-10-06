import java.util.*;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {0, 0});
        
        // bfs 실행
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0]; int y = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int mx = x + dx[i]; int my = y + dy[i];
                
                // 좌표를 벗어나는 경우
                if(mx < 0 || mx >= maps.length || 
                   my < 0 || my >= maps[0].length) {
                    continue;
                }
                
                // 벽인 경우 or 이미 방문한 경우
                if(maps[mx][my] == 0 || maps[mx][my] > 1) {
                    continue;
                }
                
                maps[mx][my] = maps[x][y] + 1;
                queue.offer(new int[] {mx, my});
            }
        }
        
        if(maps[maps.length-1][maps[0].length-1] == 1) 
            return -1;
        return maps[maps.length-1][maps[0].length-1];
    }
}