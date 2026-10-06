import java.util.*;

class Solution {
    static int[][] mG;
    static boolean[][] visited;
    static PriorityQueue<Integer> answerQ = new PriorityQueue<>();
    static int day;
    static int[] dx = new int[] {0, 0, 1, -1};
    static int[] dy = new int[] {1, -1, 0, 0};
    public int[] solution(String[] maps) {
        
        visited = new boolean[maps.length][maps[0].length()];
        mG = new int[maps.length][maps[0].length()];
        
        // 맵 구조 초기화(X = 0, 나머지는 숫자 그대로)
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                char cur = maps[i].charAt(j);
                if(cur == 'X') {
                    mG[i][j] = 0;
                }
                else {
                    mG[i][j] = cur - '0';
                }
            }
        }
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(mG[i][j] != 0 && visited[i][j] == false) {
                    day = mG[i][j];
                    visited[i][j] = true;
                    dfs(i, j);
                    answerQ.offer(day);
                }
            }
        }
        if(answerQ.size() == 0) return new int[] {-1};
        
        int[] answer = new int[answerQ.size()];
        int idx = 0;
        while(!answerQ.isEmpty()) {
            answer[idx++] = answerQ.poll();
        }
        
        return answer;
    }
    
    static void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i]; int my = y + dy[i];
            
            // 좌표를 벗어나는 경우
            if(mx < 0 || mx >= mG.length || my < 0 || my >= mG[0].length) {
                continue;
            }
            
            // 식량이 없는 경우 || 이미 방문한 경우
            if(visited[mx][my] == true || mG[mx][my] == 0) {
                continue;
            }
            
            day += mG[mx][my];
            visited[mx][my] = true;
            dfs(mx, my);
        }
    }
}