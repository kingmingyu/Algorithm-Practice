import java.io.*;
import java.util.*;

class Solution {
    public static HashSet<Integer> pSet;
    public int solution(String numbers) {
        pSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++) {
            String cur = String.valueOf(numbers.charAt(i));
            visited[i] = true;
            dfs(cur, visited, numbers);
            visited[i] = false;
        }
        return pSet.size();
    }
    
    public static void dfs(String cur, boolean[] visited, String numbers) {
        if(isPrimary(cur)) {
            pSet.add(Integer.valueOf(cur));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i] == false) {
                visited[i] = true;
                dfs(cur + numbers.charAt(i), visited, numbers);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrimary(String cur) {
        int n = Integer.valueOf(cur);
        if(n == 0 || n == 1) return false;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}