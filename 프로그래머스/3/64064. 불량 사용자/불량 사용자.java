import java.util.*;
import java.io.*;

class Solution {
    public static HashSet<String> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        set = new HashSet<>();
        
        int[][] banCnt = new int[banned_id.length][user_id.length];
        
        for(int i = 0; i < banned_id.length; i++) {
            String b = banned_id[i];
            for(int j = 0; j < user_id.length; j++) {
                boolean isSame = true;
                String u = user_id[j];
                
                // 같은지 비교
                // 자리수가 다른 경우
                if(u.length() != b.length()) {
                    continue;
                }
                
                // 문자열이 같은지 비교
                for(int bi = 0; bi < b.length(); bi++) {
                    // *인경우 비교에서 제외
                    if(b.charAt(bi) == '*') 
                        continue;
                    else {
                        if(b.charAt(bi) != u.charAt(bi)) {
                            isSame = false;
                            break;
                        }
                    }
                }
                if(isSame) {
                    //System.out.println("banned:" + b + "/ user: " + u);
                    banCnt[i][j] += 1;  
                }
            }
        }
        
        boolean[] visited = new boolean[user_id.length];
        dfs(banCnt, visited, 0);
        return set.size();
    }
    
    public static void dfs(int[][] banCnt, boolean[] visited, int s) {
        if(s >= banCnt.length) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    sb.append(i);
                }
            }
            set.add(sb.toString());
            return;
        }
        for(int i = 0; i < banCnt[s].length; i++) {
            if(banCnt[s][i] == 1 && visited[i] == false) {
                visited[i] = true;
                dfs(banCnt, visited, s+1);
                visited[i] = false;
            }
        }
    }
}