import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int borrow = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0; i < reserve.length; i++) {
            for(int j = 0; j < lost.length; j++) {
                if(reserve[i] == lost[j]) {
                    reserve[i] = -1;
                    lost[j] = -1;
                    n += 1;
                }
            }
        }
        
        for(int i = 0; i < reserve.length; i++) {
            for(int j = 0; j < lost.length; j++) {
                if(Math.abs(reserve[i] - lost[j]) == 1) {
                    borrow++;
                    reserve[i] = -1;
                    lost[j] = -1;
                }
            }
        }
        
        System.out.println("borrow: " + borrow);
        System.out.println("lost: " + lost.length);
        return n - lost.length + borrow;
    }
}