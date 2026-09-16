import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) {
            indexMap.put(enroll[i], i);
        }
        int[] parent = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            if(referral[i].equals("-")) 
                parent[i] = -1;
            else {
                parent[i] = indexMap.get(referral[i]);
            }
        }
        
        // 자산 분배
        int[] answer = new int[enroll.length];
        for(int i = 0; i < amount.length; i++) {
            int idx = indexMap.get(seller[i]);
            int money = amount[i] * 100;
            while(idx != -1) {
                int fee = money / 10;
                answer[idx] += money - fee;
                idx = parent[idx];
                money = fee;
            }
        }
        
        return answer;
    }
}