import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        // x + y == l
        int l = (brown + 4) / 2 - 4;
        
        int i = 1;
        while(i < l) {
            if((l - i) * i == yellow) {
                return new int[] {l - i + 2, i + 2};
            }
            i++;
        }
        
        return null;
    }
}