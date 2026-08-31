import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int s = 0;
        int sum = 0;
        int ansLen = Integer.MAX_VALUE;
        int[] result = new int[2];
        for(int e = 0; e < sequence.length; e++) {
            sum += sequence[e];
            while(sum > k) { sum -= sequence[s]; s++; }
            if(sum == k && e - s < ansLen) {
                ansLen = e - s;
                result[0] = s; result[1] = e;
            }
            
        }
        return result;
    }
}