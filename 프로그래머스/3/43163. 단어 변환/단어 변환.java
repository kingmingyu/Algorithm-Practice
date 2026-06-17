import java.util.*;
import java.io.*;

class Solution {
    static String[] wordsG;
    static boolean[] visited;
    static String targetG;
    static int answer = 999999;
    static int curAnswer = 0;
    public int solution(String begin, String target, String[] words) {
        // 자료구조 초기화
        wordsG = words;
        visited = new boolean[words.length];
        targetG = target;
        
        // target이 words에 없는 경우 제외
        boolean isContains = false;
        for(String str : words) {
            if(str.equals(target)) {
                isContains = true;
            }
        }
        if(isContains == false || begin.equals(target)) {
            return 0;
        }
        dfs(begin);
        
        // 정답 반환
        return answer;
    }
    
    public void dfs(String s) {
        if(s.equals(targetG)) {
            answer = Math.min(answer, curAnswer);
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            String cur = s.substring(0, i) + s.substring(i + 1, s.length());
            
            for(int j = 0; j < wordsG.length; j++) {
                String target = wordsG[j].substring(0, i) + wordsG[j].substring(i + 1, wordsG[j].length());
                if(target.equals(cur) && visited[j] == false) {
                    visited[j] = true;
                    curAnswer++;
                    dfs(wordsG[j]);
                    visited[j] = false;
                    curAnswer--;
                }
            }
        }
    }
}