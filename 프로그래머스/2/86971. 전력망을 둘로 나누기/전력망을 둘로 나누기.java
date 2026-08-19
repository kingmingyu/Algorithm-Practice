import java.util.*;
import java.io.*;

class Solution {
    public static int[][] map;
    public static int nG;
    public static int[] visited;
    public static int cnt = 0;
    public static int curAnswer = 1;
    public static int answer = 101;
    public int solution(int n, int[][] wires) {
        // 1. 자료구조 초기화
        nG = n;
        map = new int[n + 1][n + 1];
        // 그래프 그리기
        for(int[] cur : wires) {
            map[cur[0]][cur[1]] = 1;
            map[cur[1]][cur[0]] = 1;
        }
        // for(int i = 1; i < n+1; i++) {
        //     for(int j = 1; j < n+1; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        visited = new int[n + 1];
        
        // 2. dfs 호출
        for(int cur[] : wires) {
            
            // 그래프를 끊은 경우 연결된 노드 개수
            map[cur[0]][cur[1]] = 0;
            map[cur[1]][cur[0]] = 0;
            visited[1] = 1;
            dfs(1);
            //System.out.println(curAnswer);
            curAnswer = Math.abs((Math.abs(n - curAnswer)) - curAnswer);
            answer = Math.min(answer, curAnswer);

            // 다음 경우의 수를 위해 다시 돌려놓음
            curAnswer = 1;
            map[cur[0]][cur[1]] = 1;
            map[cur[1]][cur[0]] = 1;
            for(int k = 1; k < n+1; k++) {
                visited[k] = 0;
            }
        }
        
        // 3. 정답 반환
        return answer;
    }
    public static void dfs(int i) {
        
        for(int j = 1; j < nG+1; j++) {
            if(map[i][j] == 1 && visited[j] == 0) {
                curAnswer++;
                visited[j] = 1;
                dfs(j);
            }
        }
        return;
    }
}