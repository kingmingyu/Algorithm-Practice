import java.util.*;
import java.io.*;

class Solution {
    static int[][] map;
    static boolean[] visited;
    static int nG;
    static int cnt;
    static int answer;
    public int solution(int n, int[][] wires) {
        nG = n; visited = new boolean[n+1]; answer = 101;
        map = new int[n+1][n+1];
        for(int[] w : wires) {
            map[w[0]][w[1]] = 1;
            map[w[1]][w[0]] = 1;
        }
        
        for(int[] w : wires) {
            // 연결된 전력망 1개 끊기
            map[w[0]][w[1]] = 0;
            map[w[1]][w[0]] = 0;
            
            // 전력망의 차이 세기
            int n1 = 0;
            int n2 = 0;
            for(int i = 1; i < n+1; i++) {
                if(n1 == 0 && visited[i] == false) {
                    cnt = 0;
                    dfs(i);
                    n1 = cnt;
                }
                if(n1 != 0 && n2 == 0 && visited[i] == false) {
                    cnt = 0;
                    dfs(i);
                    n2 = cnt;
                }
                if(n1 != 0 && n2 != 0)
                    break;
            }
            // 정답 최신화(절댓값이 가장 작은 값)
            answer = Math.min(answer, Math.abs(n1 - n2));
            
            // 다시 초기화
            for(int i = 0; i < n + 1; i++) {
                visited[i] = false;
            }
            map[w[0]][w[1]] = 1;
            map[w[1]][w[0]] = 1;
        }
        
        return answer;
    }
    
    static void dfs(int s) {
        visited[s] = true;
        cnt++;
        for(int i = 1; i < nG+1; i++) {
            if(map[s][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }
}