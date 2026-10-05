import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int[] nG;
    static int tG;
    public int solution(int[] numbers, int target) {
        answer = 0; nG = numbers; tG = target;
        
        dfs(numbers[0], 1);
        dfs(numbers[0] * -1, 1);
        
        return answer;
    }
    
    static void dfs(int n, int i) {
        if(i == nG.length) {
            if(n == tG) answer++;
            return;
        }
        
        dfs(n + nG[i], i+1);
        dfs(n - nG[i], i+1);
    }
}