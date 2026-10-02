import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 약관 맵
        HashMap<String, Integer> termMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] t = terms[i].split(" ");
            
            termMap.put(t[0], Integer.parseInt(t[1]));
        }
        
        // 오늘 날짜
        String[] t = today.split("\\.");
        int curY = Integer.parseInt(t[0].substring(2, 4));
        int curM = Integer.parseInt(t[1]);
        int curD = Integer.parseInt(t[2]);
        
        long cur = curY * (12 * 28) + curM * 28 + curD;
        
        // 약관 별 날짜 계산 및 정답 추가
        PriorityQueue<Integer> answerQ = new PriorityQueue<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] dayTerm = privacies[i].split(" ");
            String[] curDay = dayTerm[0].split("\\.");
            
            int y = Integer.parseInt(curDay[0].substring(2, 4));
            int m = Integer.parseInt(curDay[1]);
            int d = Integer.parseInt(curDay[2]);
            String term = dayTerm[1];
            
            long pCur = y * (12 * 28) + m * 28 + d + termMap.get(term) * 28 - 1;
            if(pCur < cur) answerQ.add(i + 1);
        }
        
        int[] answer = new int[answerQ.size()];
        int idx = 0;
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerQ.poll();
        }
        
        return answer;
    }
}