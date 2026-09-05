import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // record 맵
        HashMap<String, String> rMap = new HashMap<>();
        // 차량에 대한 총 주차시간을 저장하는 맵
        Map<String, Integer> answerMap = new TreeMap<>();
        
        for(int i = 0; i < records.length; i++) {
            String[] rArr = records[i].split(" ");
            String t = rArr[0]; // 시간
            String carN = rArr[1]; // 차량 번호
            String status = rArr[2]; // IN, OUT 상태
            
            if(status.equals("IN")) {
                rMap.put(carN, t);
            }
            else {
                String carInT = rMap.get(carN);
                int totalT = calcT(carInT, t);
                answerMap.put(carN, answerMap.getOrDefault(carN, 0) + totalT);
                rMap.remove(carN);
            }
        }
        // 아직 출차하지 않은 차들은 23:59분으로 출차처리
        for(String k : rMap.keySet()) {
            String t = rMap.get(k);
            int totalT = calcT(t, "23:59");
            answerMap.put(k, answerMap.getOrDefault(k, 0) + totalT);
        }
        
        // 차량들 요금 정산
        int[] answer = new int[answerMap.size()];
        int i = 0;
        for(String k : answerMap.keySet()) {
            if(answerMap.get(k) <= fees[0]) {
                answer[i++] = fees[1];
            }
            else {
                answer[i++] = fees[1] + 
                    ((answerMap.get(k) - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
            }
        }
        
        // 번호순으로 정렬 후 정답 반환
        
        return answer;
    }
    
    static int calcT(String s, String e) {
        String[] sArr = s.split(":");
        String[] eArr = e.split(":");
        int sH = Integer.parseInt(sArr[0]);
        int sM = Integer.parseInt(sArr[1]);
        int eH = Integer.parseInt(eArr[0]);
        int eM = Integer.parseInt(eArr[1]);
        
        
        return (eH * 60 + eM) - (sH * 60 + sM); 
    }
}