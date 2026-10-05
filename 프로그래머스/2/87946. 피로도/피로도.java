import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int curAnswer;
    static int kG;
    static int[][] dG;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0; curAnswer = 0; kG = k;
        dG = dungeons;
        visited = new boolean[dungeons.length];
        
        for(int i = 0; i < dungeons.length; i++) {
            visited[i] = true; kG -= dungeons[i][1];
            curAnswer++;
            dfs();
            visited[i] = false; kG += dungeons[i][1];
            curAnswer--;
        }
        
        return answer;
    }
    
    static void dfs() {
        answer = Math.max(curAnswer, answer);
        
        for(int i = 0; i < dG.length; i++) {
            if(visited[i] == false && kG - dG[i][0] >= 0) {
                visited[i] = true; kG -= dG[i][1];
                curAnswer++;
                dfs();
                visited[i] = false; kG += dG[i][1];
                curAnswer--;
            }
        }
    }
}