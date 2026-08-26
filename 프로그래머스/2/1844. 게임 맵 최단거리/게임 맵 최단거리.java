import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = new int[] { 0, 0, -1, 1 };
        int[] dy = new int[] { -1, 1, 0, 0 };
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0,0});
        
        while(!queue.isEmpty()) {
            int cur[] = queue.poll();
            
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i =0; i < 4; i++) {
                int mx = curX + dx[i];
                int my = curY + dy[i];
                
                if(mx < 0 || my < 0 || mx >= maps.length || my >= maps[0].length)
                    continue;
                if(maps[mx][my] == 1) {
                    maps[mx][my] = maps[curX][curY] + 1;
                    queue.add(new int[] {mx,my});
                }
            }
        }
        
        if(maps[maps.length - 1][maps[0].length - 1] == 1) return -1;
        return maps[maps.length - 1][maps[0].length - 1];
    }
}