import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] p1 = { 1, 2, 3, 4, 5 };
        int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        int max = answers.length;
        // 각각 정답 개수 구하기
        for(int i = 0; i < max; i++) {
            if(answers[i] == p1[i%(p1.length)]) {
                cnt1++;
            }
        }
        for(int i = 0; i < max; i++) {
            if(answers[i] == p2[i%(p2.length)]) {
                cnt2++;
            }
        }
        for(int i = 0; i < max; i++) {
            if(answers[i] == p3[i%(p3.length)]) {
                cnt3++;
            }
        }
        
        int[] answer;
        if(cnt1 == cnt2 && cnt2 == cnt3) {
            answer = new int[]{ 1, 2, 3 };
        }
        else if(cnt1 == cnt2 && cnt1 > cnt3) {
            answer = new int[]{ 1, 2 };
        }
        else if(cnt3 == cnt2 && cnt3 > cnt1) {
            answer = new int[]{ 2, 3 };
        }
        else if(cnt3 == cnt1 && cnt3 > cnt2) {
            answer = new int[]{ 1, 3 };
        }
        else {
            if(cnt1 > cnt2 && cnt1 > cnt3) {
                answer = new int[]{ 1 };
            }
            else if(cnt2 > cnt1 && cnt2 > cnt3) {
                answer = new int[]{ 2 };
            }
            else {
                answer = new int[]{ 3 };
            }
        }
            
        return answer;
    }
}