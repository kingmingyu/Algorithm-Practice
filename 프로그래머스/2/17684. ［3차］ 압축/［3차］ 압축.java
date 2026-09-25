import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dic = new HashMap<>();
        String[] alpha = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", };
        for(int i = 0; i < 26; i++) {
            dic.put(alpha[i], i+1);
        }
        
        msg.toUpperCase();
        String cur = "";
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < msg.length(); i++) {
            cur += msg.charAt(i);
            if(dic.containsKey(cur)) {
                continue;
            }
            else {
                String prev = cur.substring(0, cur.length()-1);
                // System.out.println(dic.get(prev));
                answer.add(dic.get(prev));
                dic.put(cur, dic.size() + 1);
                //System.out.println(cur + ": " + dic.size());
                cur = "";
                i--;
            }
        }
        if(!cur.isEmpty()) answer.add(dic.get(cur));
        int[] answerArr = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            answerArr[i] = answer.get(i);
        }
        return answerArr;
        
        // return new int[] {1};
    }
}