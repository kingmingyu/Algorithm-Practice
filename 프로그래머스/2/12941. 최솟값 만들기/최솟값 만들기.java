import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] As = new Integer[A.length];
        for(int i = 0; i < A.length; i++) {
            As[i] = A[i];
        }
        Arrays.sort(As);
        Integer[] Bs = new Integer[B.length];
        for(int i = 0; i < B.length; i++) {
            Bs[i] = B[i];
        }
        Arrays.sort(Bs, Collections.reverseOrder());

        for(int i = 0; i < As.length; i++) {
            answer += As[i] * Bs[i];
        }

        return answer;
    }
}