import java.util.*;
import java.io.*;

class Solution {
    public int solution(String dirs) {
        
        // 플레이어 좌표
        int cx = 5;
        int cy = 5;
        
        // 방문 체크
        HashSet<String> visited = new HashSet<>();
        
        int answer = 0;
        for(int i = 0; i < dirs.length(); i++) {
            char move = dirs.charAt(i);
            if(move == 'U') {
                int my = cy + 1;
                if(my > 10) continue;
                String move1 = "" + cx + cy + cx + my;
                if(visited.contains(move1)) {
                    cy = my;
                    continue;
                }
                String move2 = "" + cx + my + cx + cy;
                visited.add(move1); visited.add(move2); 
                cy = my;
                answer++;
                
            }
            else if (move == 'L') {
                int mx = cx - 1;
                if(mx < 0) continue;
                String move1 = "" + cx + cy + mx + cy;
                if(visited.contains(move1)) {
                    cx = mx;
                    continue;
                }
                String move2 = "" + mx + cy + cx + cy;
                visited.add(move1); visited.add(move2); 
                cx = mx;
                answer++;
            }
            else if (move == 'R') {
                int mx = cx + 1;
                if(mx > 10) continue;
                String move1 = "" + cx + cy + mx + cy;
                if(visited.contains(move1)) {
                    cx = mx;
                    continue;
                }
                String move2 = "" + mx + cy + cx + cy;
                visited.add(move1); visited.add(move2); 
                cx = mx;
                answer++;
            }
            else {
                int my = cy - 1;
                if(my < 0) continue;
                String move1 = "" + cx + cy + cx + my;
                if(visited.contains(move1)) {
                    cy = my;
                    continue;
                }
                String move2 = "" + cx + my + cx + cy;
                visited.add(move1); visited.add(move2); 
                cy = my;
                answer++;
            }
        }
        
        return answer;
    }
}