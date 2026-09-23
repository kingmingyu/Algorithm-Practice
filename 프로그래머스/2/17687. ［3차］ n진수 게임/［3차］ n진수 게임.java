import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        StringBuilder answer = new StringBuilder();
        int curN = 0;
        int cnt = 0;
        for(int i = p-1; cnt < t; i += m) {
            while(i >= sb.length()) {
                sb.append(change(curN++, n));
            }
            answer.append(sb.charAt(i));
            cnt++;
        }
        
        return answer.toString();
    }
    
    // 진수 변환
    public static String change(int n, int k) {
        if(n == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.append(over10(n % k));
            n /= k;
        }
        sb.reverse();
        return sb.toString();
    }
    
    public static String over10(int n) {
        if(n == 10) return "A";
        else if(n == 11) return "B";
        else if(n == 12) return "C";
        else if(n == 13) return "D";
        else if(n == 14) return "E";
        else if(n == 15) return "F";
        else return String.valueOf(n);
    }
}