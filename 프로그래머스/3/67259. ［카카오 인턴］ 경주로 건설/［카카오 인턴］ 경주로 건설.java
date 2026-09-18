import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board) {
        // 방문 배열
        int[][][] cost = new int[board.length][board.length][2];
        // Arrays.fill(cost, Integer.MAX_VALUE);
        // 큐
        Deque<int[]> queue = new ArrayDeque<>();
        // 이동 배열
        int[] dx = new int[] { 1, -1, 0, 0 };
        int[] dy = new int[] { 0, 0, 1, -1 };
        
        // 시작
        queue.offer(new int[] {0, 0, 0});
        queue.offer(new int[] {0, 0, 1});
        cost[0][0][0] = 1;
        cost[0][0][1] = 1;
        
        // bfs를 수행하면서 가장 작은 값 넣기
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int direction = cur[2];
            
            for(int i = 0; i < 4; i++) {
                int mx = curX + dx[i];
                int my = curY + dy[i];
                
                // 보드를 벗어난 경우
                if(mx < 0 || mx >= board.length || my < 0 || my >= board.length) {
                    continue;
                }
                
                if(board[mx][my] == 0) {
                    int nextDirection = (i <= 1) ? 0 : 1;

                    int newCost;

                    if(direction != nextDirection) {
                        // 곡선
                        newCost = cost[curX][curY][direction] + 600;
                    } else {
                        // 직선
                        newCost = cost[curX][curY][direction] + 100;
                    }

                    if(cost[mx][my][nextDirection] == 0 ||
                       newCost < cost[mx][my][nextDirection]) {

                        cost[mx][my][nextDirection] = newCost;
                        queue.offer(new int[] {mx, my, nextDirection});
                    }
                }
            }
        }
        
        if(cost[board.length-1][board.length-1][0] == 0) 
            return cost[board.length-1][board.length-1][1] - 1;
        if(cost[board.length-1][board.length-1][1] == 0)
            return cost[board.length-1][board.length-1][0] - 1;
        return Math.min(cost[board.length-1][board.length-1][0] - 1,
                        cost[board.length-1][board.length-1][1] - 1);
    }
}