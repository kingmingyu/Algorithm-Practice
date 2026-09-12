import java.util.*;
import java.io.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long sumE = 0;
        long sumO = 0;
        int curE = sequence[0];
        int curO = sequence[0];
        for(int e = 0; e < sequence.length; e++) {
            curE = sequence[e] * perse(true, e);
            curO = sequence[e] * perse(false, e);
            //System.out.println("cur: " + cur);
            sumE += curE;
            sumO += curO;
            if(sumE < 0) {
                sumE = 0;
            }
            if(sumO < 0) {
                sumO = 0;
            }
            answer = Math.max(answer, sumE);
            answer = Math.max(answer, sumO);
            //System.out.println("sum: " + sum);
        }
        
        return answer;
    }
    
    public static int perse(boolean oddM, int idx) {
        if(oddM) {
            if(idx % 2 != 0) return -1;
            else return 1;
        }
        else {
            if(idx % 2 != 0) return 1;
            else return -1;
        }
    }
}