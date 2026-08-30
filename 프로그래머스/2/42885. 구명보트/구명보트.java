import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        // 배열 정렬
        Arrays.sort(people);
        int answer = 0;
        // two pointer
        int max = people.length - 1;
        int min = 0;
        
        while(max >= min) {
            if(people[max] + people[min] <= limit) {
                min++;
            }
            max--;
            answer++;
        }
        
        // 정답 반환
        return answer;
    }
}