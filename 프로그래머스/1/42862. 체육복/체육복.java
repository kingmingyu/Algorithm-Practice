import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] cnt = new int[n + 2];
        for(int i = 1; i <= n; i++) cnt[i] = 1;
        for(int l : lost) cnt[l] -= 1;
        for(int r : reserve) cnt[r] += 1;
        
        for(int i = 1; i <= n; i++) {
            if(cnt[i] != 0) continue;
            
            if(cnt[i - 1] == 2) {
                cnt[i-1] --; cnt[i]++;
            }
            else if (cnt[i+1] == 2) {
                cnt[i+1] --; cnt[i]++;
            }
        }
        
        int ans = 0;
        for(int i = 1; i <= n; i++) if(cnt[i] >= 1) ans++;
        return ans;
    }
}