import java.util.*;
import java.io.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        
        for(int v = x; v <= y; v++) {
            if(dp[v] == Integer.MAX_VALUE) continue;
            
            int next = dp[v] + 1;
            if(v + n <= y) dp[v+n] = Math.min(dp[v+n], next);
            if(v * 2 <= y) dp[v*2] = Math.min(dp[v*2], next);
            if(v * 3 <= y) dp[v*3] = Math.min(dp[v*3], next);
        }
        
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}