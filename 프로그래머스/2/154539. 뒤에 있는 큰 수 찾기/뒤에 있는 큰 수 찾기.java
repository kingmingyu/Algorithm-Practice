import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        return result;
    }
}