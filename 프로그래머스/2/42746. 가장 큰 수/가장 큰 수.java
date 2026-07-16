import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        // Integer 배열로 변환
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        Arrays.sort(nums, (Integer a, Integer b) -> {
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);
            
            // 내림차순 정렬
            return (sb+ sa).compareTo(sa + sb);
        });
        
        for(int i : nums) {
            answer.append(i);
        }
        
        if(answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}