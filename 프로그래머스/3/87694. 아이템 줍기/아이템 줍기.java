import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] mx = new int[] { 0, 0, 1, -1 };
        int[] my = new int[] { 1, -1, 0, 0 };
        
        // map 제작, 2배 곱해서 제작(ㄷ자로 붙어있는 경우에 점프할 수 있기 때문)
        int map[][] = new int[102][102];
        for(int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for(int x = x1; x <= x2; x++) {
                for(int y = y1; y <= y2; y++) {
                    if(x == x1 || x == x2 || y == y1 || y == y2) {
                        if(map[x][y] != 2) {
                            map[x][y] = 1;
                        }
                    }
                    else {
                        map[x][y] = 2;
                    }
                }
            }
        }
        
        queue.offer(new int[] { characterX * 2, characterY * 2, 0 });
        boolean[][] visited = new boolean[102][102];
        visited[characterX * 2][characterY * 2] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            // 정답인 경우
            if(cur[0] == itemX * 2 && cur[1] == itemY * 2) {
                return cur[2] / 2;
            }
            
            for(int j = 0; j < 4; j++) {
                int dx = cur[0] + mx[j];
                int dy = cur[1] + my[j];
                
                // 좌표를 벗어나는 경우
                if(dx < 2 || dx > 100 || dy < 2 || dy > 100) {
                    continue;
                }
                if(map[dx][dy] == 1 && visited[dx][dy] == false) {
                    visited[dx][dy] = true;
                    queue.offer(new int[] {dx, dy, cur[2] + 1});
                }
                
            }
        }
        return 0;
    }
}