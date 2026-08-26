import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int[] answer = new int[2];
        map.put(words[0], 1);
        for(int i = 1; i < words.length; i++) {
            String w = words[i];
            String prevW = words[i-1];
            
            // 이미 있는 단어를 말하는 경우
            if(map.getOrDefault(w, 0) == 1) {
                // System.out.println("단어 이미 있음");
                // System.out.println(w);
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            // 끝말잇기 규칙을 어긴 경우
            if(i != 0 && prevW.charAt(prevW.length() - 1) != w.charAt(0)) {
                // System.out.println("규칙 어김");
                // System.out.println(w);
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            map.put(w, 1);
        }
        
        return answer;
    }
}
// 1 2 1 2 1
// 1 0 1 0 1
// 0 1 1 2 2