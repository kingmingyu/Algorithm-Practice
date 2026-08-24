import java.util.*;;
import java.io.*;

class Solution {
    public int solution(String name) {
        char[] alpha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        
        int answer = 0;
        int minMove = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            char cur = name.charAt(i);
            int idx = 0;
            
            for(int j = 0; j < alpha.length; j++) {
                if(cur == alpha[j]) {
                    idx = j;
                    break;
                }
            }
            
            // 더 작은 경우 더하기
            answer += Math.min(alpha.length - idx, idx);
            
            // 이동하는 짧은 경우의 수
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            // 왼쪽으로 갔다가 오른쪽으로 꺾는 경우
            int leftThenRight = (name.length() - next) * 2 + i;
            
            // 오른쪽으로 갔다가 왼쪽으로 꺾는 경우
            int rightThenLeft = i * 2 + (name.length() - next);
            
            minMove = Math.min(minMove, Math.min(leftThenRight, rightThenLeft));
        }
        answer += minMove;
        return answer;
    }
}