class Solution {
    public int solution(int storey) {
        // 현재 자리수가 5보다 작으면 그대로 +
        // 5보다 크면 10 - 자리수 + 1
        
        int answer = 0;
        while(storey > 0) {
            int cur = storey % 10;
            storey /= 10;
            
            if(cur < 5) {
                answer += cur;
            }
            else if (cur == 5) {
                if(storey % 10 < 5) {
                    answer += cur;
                }
                else {
                    answer += cur;
                    storey++;
                }
            }
            else {
                answer += 10 - cur;
                storey++;
            }
        }
        
        return answer;
    }
}