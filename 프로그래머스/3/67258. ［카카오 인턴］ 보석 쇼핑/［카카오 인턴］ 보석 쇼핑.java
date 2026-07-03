import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        
        int answer = 999999;
        int s = 0;
        int e = 0;
        int answerS = 0;
        int answerE = 0;
        HashMap<String, Integer> check = new HashMap<>();
        for(e = 0; e < gems.length; e++) {
            check.put(gems[e], check.getOrDefault(gems[e], 0) + 1);
            while(check.keySet().size() == set.size()) {
                if(check.get(gems[s]) == 1) {
                    check.remove(gems[s]);
                    s += 1;
                    if(e - s < answer) {
                        answer = e - s;
                        answerS = s;
                        answerE = e;
                    }
                    break;
                }
                else {
                    check.put(gems[s], check.get(gems[s]) - 1);
                    s += 1;
                }
            }
        }
        return new int[] {answerS, answerE + 1};
    }
} 