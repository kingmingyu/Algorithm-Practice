import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] citationsInte = 
            Arrays.stream(citations).boxed().toArray(Integer[]::new);
        
        // 인용된 횟수 내림차순 정렬
        Arrays.sort(citationsInte, Collections.reverseOrder());
        
        // 앞에서부터 순차적으로 돌면서 i번째 해당하는 값이 i개 이상 있는지 체크
        int h = citationsInte.length;
        while(true) {
            int cnt = 0;
            for(int i = 0; i < citationsInte.length; i ++) {
                if(citationsInte[i] >= h) {
                    // System.out.println("h: " + h + " / citationsInte[i]: " + citationsInte[i]);
                    cnt++;
                    if(cnt >= h) {
                        return h;
                    }
                }
            }
            h--;
        }
    }
}