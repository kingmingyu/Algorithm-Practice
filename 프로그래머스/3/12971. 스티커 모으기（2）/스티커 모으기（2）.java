import java.util.*;
import java.io.*;

class Solution {
    public int solution(int sticker[]) {
        int l = sticker.length;
        
        if(l == 1) return sticker[0];
        
        // 처음 스티커를 뜯는 경우(마지막 미포함)
        int[] dp1 = new int[l];
        
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        
        for(int i = 2; i < l-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
        
        // 처음 스티커를 뜯지 않는 경우(마지막 포함)
        int[] dp2 = new int[l];
        
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for(int i = 2; i < l; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        
        return Math.max(dp1[l-2], dp2[l-1]);
    }
}