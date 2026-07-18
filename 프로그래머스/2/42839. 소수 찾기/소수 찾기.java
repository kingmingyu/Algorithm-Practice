import java.io.*;
import java.util.*;

class Solution {
    public static HashSet<Integer> primary = new HashSet<>();
    
    public int solution(String numbers) {
        dfs("", numbers);
        
        int answer = 0;
        for(Integer i : primary) {
            if(isPrimary(i)) {
                answer++;
                // System.out.println(i);
            }
        }
        return answer;
    }
    
    public static void dfs(String comb, String others) {
        if(!comb.equals("")) {
            primary.add(Integer.parseInt(comb));
        }
        
        for(int i = 0; i < others.length(); i++) {
            dfs(comb + others.charAt(i),
               others.substring(0, i) + others.substring(i+1));
        }
    }
    
    public static boolean isPrimary(int n) {
        if(n == 0 || n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}