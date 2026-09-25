import java.util.*;
import java.io.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        // 스킬 세트
        HashSet<Character> skillSet = new HashSet<>();
        for(int i = 0; i < skill.length(); i++) {
            skillSet.add(skill.charAt(i));
        }
        
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++) {
            int idx = 0;
            String st = skill_trees[i];
            boolean isAnswer = true;
            
            for(int j = 0; j < st.length(); j++) {
                if(idx < skill.length() && skillSet.contains(st.charAt(j))) {
                    if(st.charAt(j) == skill.charAt(idx)) {
                        idx++;
                    }
                    else {
                        isAnswer = false;
                        break;
                    }
                }
            }
            
            if(isAnswer) {
                //System.out.println(st);
                answer++;
            }
        }
        
        return answer;
    }
}