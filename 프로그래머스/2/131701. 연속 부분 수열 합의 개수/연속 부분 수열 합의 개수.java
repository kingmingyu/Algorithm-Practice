import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 1; i < elements.length; i++) {
            // 원소가 i개인 경우
            for(int j = 0; j < elements.length; j++) {
                int sum = 0;
                for(int k = 0; k < i; k++) {
                    sum += elements[(j + k) % (elements.length)];
                }
                set.add(sum);
            }
        }
        return set.size() + 1;
    }
}