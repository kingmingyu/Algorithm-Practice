import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k) {
        
        //진수 변환
        String changeN = change(n, k);
        
        // 0을 기준으로 나누기
        String[] diviedBy0 = changeN.split("0");
        
        // 소수 개수 찾기
        int answer = 0;
        for(int i = 0; i < diviedBy0.length; i++) {
            if(diviedBy0[i].isEmpty()) continue;
            long cur = Long.parseLong(diviedBy0[i]);
            if(isPrime(cur)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public static boolean isPrime(long n) {
        if(n == 1) return false;
        for(long i = 2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public static String change(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.append(String.valueOf(n % k));
            n /= k;
        }
        sb.reverse();
        return sb.toString();
    }
}