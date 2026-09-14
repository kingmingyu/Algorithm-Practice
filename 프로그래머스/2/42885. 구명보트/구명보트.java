import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 배열 정렬
        Integer[] peopleI = new Integer[people.length];
        for(int i = 0; i < people.length; i++) {
            peopleI[i] = people[i];
        }
        Arrays.sort(peopleI, Collections.reverseOrder());
        
        
        int s = 0;
        int e = people.length - 1;
        int answer = 0;
        while(s <= e) {
            int limitP = 0;
            int curL = limit;
            // 가장 무거운 사람 태우기
            while(limitP < 2 && s <= e) {
                if(curL - peopleI[s] >= 0) {
                    curL -= peopleI[s++];
                    limitP++;
                }
                else {
                    break;
                }
            }
            // 가장 가벼운 사람 태우기
            while(limitP < 2 && s <= e) {
                if(curL - peopleI[e] >= 0) {
                    curL -= peopleI[e--];
                    limitP++;
                }
                else {
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}