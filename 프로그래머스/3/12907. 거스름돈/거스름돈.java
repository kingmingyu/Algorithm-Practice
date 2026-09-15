class Solution {
    private final int NUMBER = 1000000007;
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1; // 아무것도 고르지 않는 경우의 수
        
        for(int coin : money) {
            for(int m = coin; m <= n; m++) {
                dp[m] += dp[m - coin] % NUMBER;
            }
        }
        return dp[n];
    }
}