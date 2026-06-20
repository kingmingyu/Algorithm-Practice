import java.util.*;
import java.io.*;

class Solution {
    static String[][] ticketsG;
    static boolean[] used;
    static ArrayList<String> curAnswer;
    static ArrayList<String[]> answerList;
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        // 자료구조 초기화
        ticketsG = tickets;
        used = new boolean[tickets.length];
        curAnswer = new ArrayList<>();
        answerList = new ArrayList<>();
        
        curAnswer.add("ICN");
        dfs("ICN");
        
        answerList.sort((o1, o2) -> {
            for(int i = 0; i < o1.length; i++) {
                if(!o1[i].equals(o2[i])) {
                    return o1[i].compareTo(o2[i]);
                }
            }
            return 0;
        });
        return answerList.get(0);
    }
    
    public void dfs(String s) {
        if(curAnswer.size() == ticketsG.length + 1) {
            answer = new String[curAnswer.size()];
            for(int i = 0; i < curAnswer.size(); i++) {
                answer[i] = curAnswer.get(i);
            }
            answerList.add(answer);
            return;
        }
        
        for(int i = 0; i < ticketsG.length; i++) {
            if(used[i] == true) {
                continue;
            }
            String[] cur = ticketsG[i];
            if(cur[0].equals(s)) {
                used[i] = true;
                curAnswer.add(cur[1]);
                dfs(cur[1]);
                used[i] = false;
                curAnswer.remove(curAnswer.size() - 1);
            }
        }
    }
}