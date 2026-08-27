import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 슬라이딩 윈도우를 이용(10개 고정)
        HashMap<String, Integer> target = new HashMap<>();
        HashMap<String, Integer> curDis = new HashMap<>();
        
        for(int i = 0; i < number.length; i++) {
            target.put(want[i], number[i]);
        }
        
        // 초기 윈도우 설정
        int s = 0;
        int e = 0;
        int result = 0;
        
        while(e < discount.length) {
            int targetCnt = target.getOrDefault(discount[e], 0);
            int curDisCnt = curDis.getOrDefault(discount[e], 0);
            
            // 담으려는 상품이 아닌 경우 건너뛰기
            if(targetCnt == 0) {
                s = e;
                s++; e++;
                curDis.clear();
            }
            // 담으려는 상품에 해당하는 경우
            else{
                // 더 담아야 하는경우(e를 더해 윈도우 크기를 늘림)
                if(curDisCnt < targetCnt) {
                    curDis.put(discount[e], curDisCnt + 1);
                    
                    // 정확히 10개의 상품을 담은 경우
                    if(e - s == 9) {
                        result++;
                    }
                    e++;
                }
                // 빼야하는 경우(s를 더해 윈도우 크기를 줄임)
                else if (curDisCnt >= targetCnt) {
                    curDis.put(discount[s], curDis.get(discount[s]) - 1);
                    s++;
                }
            }
        }
        return result;
    }
}