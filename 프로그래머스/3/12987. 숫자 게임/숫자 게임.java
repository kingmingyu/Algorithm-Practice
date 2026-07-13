import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Integer[] As = new Integer[A.length];
        Integer[] Bs = new Integer[B.length];
        
        for(int i = 0; i < A.length; i++) {
            As[i] = A[i];
            Bs[i] = B[i];
        }
        
        Arrays.sort(As, Collections.reverseOrder());
        Arrays.sort(Bs, Collections.reverseOrder());
        
        int answer = 0;
        int as = 0;
        for(int b = 0; b < Bs.length; b++) {
            for(int a = as; a < As.length; a++) {
                if(As[a] < Bs[b]) {
                    //System.out.println("Bs[b]" + Bs[b] + "/ As[a]" + As[a]);
                    as = a + 1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}