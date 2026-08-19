import java.io.*;
import java.util.*;

class Solution {
    static String wordG;
    static int count;
    static String[] alpha = { "A", "E", "I", "O", "U" };
    static int answer;
    public int solution(String word) {
        wordG = word;
        
        dfs("");
        
        return answer;
    }
    
    public static void dfs(String cur) {
        if(cur.equals(wordG)) {
            answer = count;
            return;
        }
        if(cur.length() == 5) {
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            count++;
            dfs(cur + alpha[i]);
        }
        return;
    }
}