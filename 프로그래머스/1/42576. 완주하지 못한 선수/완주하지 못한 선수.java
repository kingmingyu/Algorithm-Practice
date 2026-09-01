import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> pSet = new HashMap<>();
        for(String p : participant) {
            pSet.put(p, pSet.getOrDefault(p, 0) + 1);
        }
        for(String c : completion) {
            int p = pSet.getOrDefault(c, 0);
            if (p == 1) pSet.remove(c);
            else pSet.put(c, p - 1);
        }
        for(String ans : pSet.keySet()) {
            return ans;
        }
        return "answer[0];";
    }
}