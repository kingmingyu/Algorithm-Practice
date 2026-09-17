import java.util.*;
import java.io.*;

class Solution
{
    public int solution(String s)
    {
        // 변수 선언
        int maxLen = 1;
        
        // 문자열을 돌면서 팰린드롬 탐색(시작과 끝은 제외)
        for(int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            
            // 팰린드롬 체크
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                }
                l--; r++;
            }
            
            l = i;
            r = i + 1;
            // 팰린드롬 체크
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                }
                l--; r++;
            }
        }
        
        return maxLen;
    }
}