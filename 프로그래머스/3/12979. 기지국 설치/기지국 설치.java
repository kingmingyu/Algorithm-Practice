class Solution {
    public int solution(int n, int[] stations, int w) {

        int s = 0;
        int answer = 0;
        for(int cur : stations) {
            int gap = cur-1-w - s;
            if(gap > 0) {
                if(gap % (2*w+1) == 0) {
                    answer += gap / (2*w+1);
                }
                else{
                    answer += gap / (2*w+1) + 1;
                }
                
            }
            s = cur+w;
        }
        // 마지막
        if(s < n) {
            if((n - s) % (2*w+1) == 0) {
                answer += (n - s) / (2*w+1);
            }
            else{
                answer += (n - s) / (2*w+1) + 1;
            }
        }
        
        return answer;
    }
}