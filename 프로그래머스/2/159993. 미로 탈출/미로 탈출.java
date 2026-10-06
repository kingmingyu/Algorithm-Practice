import java.util.*;

class Solution {
    // bfs 2번 = 시작 -> 스위치 + 스위치 -> 도착
    public int solution(String[] maps) {
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        
        // 맵 2차원 배열로 재구성
        char[][] cMap = new char[maps.length][maps[0].length()];
        int[][] dist = new int[maps.length][maps[0].length()];
        int sx = 0, sy = 0;
        int lx = 0, ly = 0;
        int ex = 0, ey = 0;
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                cMap[i][j] = maps[i].charAt(j);
                if(maps[i].charAt(j) == 'S') {
                    sx = i; sy = j;
                }
                if(maps[i].charAt(j) == 'L') {
                    lx = i; ly = j;
                }
                if(maps[i].charAt(j) == 'E') {
                    ex = i; ey = j;
                }
            }
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        // 레버 당기러 가기
        queue.offer(new int[] {sx, sy});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0]; int y = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int mx = x + dx[i]; int my = y + dy[i];
                
                // 좌표를 벗어나는 경우
                if(mx < 0 || mx >= cMap.length || 
                   my < 0 || my >= cMap[0].length) {
                    continue;
                }
                
                // 이미 오거나 벽인 경우
                if(dist[mx][my] != 0 || cMap[mx][my] == 'X') {
                    continue;
                }
                
                dist[mx][my] = dist[x][y] + 1;
                queue.offer(new int[] {mx, my});
            }
            
            if(dist[lx][ly] != 0) break;
        }
        
        int l = dist[lx][ly];
        if(l == 0) return -1;
        dist = new int[maps.length][maps[0].length()];
        dist[lx][ly] = l;
        queue = new ArrayDeque<>();
        
        // 레버 당기고 나서 도착하기
        queue.offer(new int[] {lx, ly});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0]; int y = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int mx = x + dx[i]; int my = y + dy[i];
                
                // 좌표를 벗어나는 경우
                if(mx < 0 || mx >= cMap.length || 
                   my < 0 || my >= cMap[0].length) {
                    continue;
                }
                
                // 이미 오거나 벽인 경우
                if(dist[mx][my] != 0 || cMap[mx][my] == 'X') {
                    continue;
                }
                
                dist[mx][my] = dist[x][y] + 1;
                queue.offer(new int[] {mx, my});
            }
            
            if(dist[ex][ey] != 0) break;
        }
        
        if(dist[ex][ey] == 0) return -1;
        return dist[ex][ey];
        
    }
}