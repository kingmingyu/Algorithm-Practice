import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> cMap = new HashMap<>();
        
        for(String[] c : clothes) {
            cMap.put(c[1], cMap.getOrDefault(c[1], 0) + 1);
        }
        
        int answer = 1;
        for(String k : cMap.keySet()) {
            answer *= cMap.get(k) + 1; // 선택하지 않는 경우 +1
        }
        
        return answer - 1;
    }
}