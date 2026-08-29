import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        // Integer 배열로 변경
        Integer[] citationsSort = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++) {
            citationsSort[i] = citations[i];
        }
        
        Arrays.sort(citationsSort, Comparator.reverseOrder());
        for(int i = 0; i < citationsSort.length; i++) {
            // h번 이상 인용된 논문
            if(i + 1 > citationsSort[i]) {
                return i;
            }
        }
        return citationsSort.length;
    }
}