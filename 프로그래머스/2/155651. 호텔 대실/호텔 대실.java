import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
        // 예약 시간 정렬
        Arrays.sort(book_time, (o1, o2) -> {
            if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        });
        
        // 현재 방 개수
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        // 초기 방 넣어주기
        pq.add(Plus10(book_time[0][1]));
        
        int answer = pq.size();
        for(int i = 1; i < book_time.length; i++) {
            String curS = book_time[i][0]; // 현재 시각
            String curE = book_time[i][1];
            
            // 현재 시간 기준 방꺼내기
            while(!pq.isEmpty() && curS.compareTo(pq.peek()) >= 0) {
                pq.poll();
            }
            
            // 방 넣기
            pq.add(Plus10(curE));
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    public static String Plus10(String time) {
        String[] tSplit = time.split(":");
        String h = tSplit[0];
        String m = tSplit[1];
        
        if(m.charAt(0) == '5') {
            String h10 = "" + (Integer.valueOf(h) + 1);
            if(Integer.valueOf(h) + 1 < 10) {
                h10 = "0" + h10;
            }
            String m10 = "0" + m.charAt(1);
            return h10 + ":" + m10;
        }
        else {
            return h + ":" + (Integer.valueOf(m) + 10);
        }
    }
}