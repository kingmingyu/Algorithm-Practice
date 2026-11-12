class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        for(int i = 0; i < players.length; i++) {
            int cur = players[i];
            
            if(cur < m) {
                continue;
            }
            else {
                answer += cur / m;
                for(int j = i; j < i + k && j < players.length; j++) {
                    players[j] -= m * (cur / m);
                }
            }
        }
        
        return answer;
    }
}