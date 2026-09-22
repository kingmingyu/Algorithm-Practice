import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashSet<String> same = new HashSet<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for(int i = 0; i < str1.length() -1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if(c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                String comb = "" + c1 + c2;
                map1.put(comb, map1.getOrDefault(comb, 0) + 1);
            }
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if(c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                String comb = "" + c1 + c2;
                map2.put(comb, map2.getOrDefault(comb, 0) + 1);
                if(map1.containsKey(comb))
                    same.add(comb);
            }
        }
        int plus = 0;
        int inter = 0;
        for(int v : map1.values()) {
            plus += v;
        }
        for(int v : map2.values()) {
            plus += v;
        }
        for(String s : same) {
            inter += Math.min(map1.get(s), map2.get(s));
        }
        
        if(plus == 0) return 65536;
        double answer = (double)inter/(plus-inter)*65536;
        return (int)answer;
    }
}