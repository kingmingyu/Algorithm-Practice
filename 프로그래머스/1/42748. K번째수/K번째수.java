import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] cur = commands[i];
            
            List<Integer> idxArr = new ArrayList<>();
            for(int j = cur[0] - 1; j < cur[1]; j++) {
                idxArr.add(array[j]);
            }
            Collections.sort(idxArr);
            answer[i] = idxArr.get(cur[2] - 1);
        }
        return answer;
    }
}