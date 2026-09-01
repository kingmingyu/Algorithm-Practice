import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        int i = 0;
        for(int[] c : commands) {
            int s = c[0]; int e = c[1]; int n = c[2];
            
            int[] cur = new int[e - s + 1];
            for(int j = 0; j < e - s + 1; j++) {
                cur[j] = array[j + s - 1];
            }
            Arrays.sort(cur);
            answer[i++] = cur[n - 1];
        }
        return answer;
    }
}