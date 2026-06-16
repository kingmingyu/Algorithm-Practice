import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int getPoket = nums.length / 2;
        HashMap<Integer, Integer> poket = new HashMap<>();
        for(int i : nums) {
            poket.put(i, poket.getOrDefault(i, 0) + 1);
        }
        if(poket.keySet().size() >= getPoket){
            return getPoket;
        }
        else{
            return poket.keySet().size();
        }
    }
}