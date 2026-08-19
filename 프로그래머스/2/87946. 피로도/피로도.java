import java.io.*;
import java.util.*;

class Solution {
    public static int maxCount = 0;
    public static int k;
    public static int[][] dungeons;
    public static int[] visited;
    public int solution(int k, int[][] dungeons) {
        // 자료구조 초기화
        this.dungeons = dungeons;
        visited = new int[dungeons.length];
        this.k = k;
        
        // dfs 호출
        dfs(0);
        
        return maxCount;
    }
    
    public static void dfs(int count) {
        maxCount = Math.max(count, maxCount);
        
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == 0 && k >= dungeons[i][0]) {
                visited[i] = 1;
                k = k - dungeons[i][1];
                dfs(count+1);
                
                k = k + dungeons[i][1];
                visited[i] = 0;
            }
        }
    }
}