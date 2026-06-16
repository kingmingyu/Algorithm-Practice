import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clo = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String[] arr = clothes[i];
            System.out.println(arr[1]);
            clo.put(arr[1], clo.getOrDefault(arr[1], 1) + 1);
        }
        
        for(String key : clo.keySet()) {
            answer *= clo.get(key);
        }
        
        return answer - 1;
    }
}