class Solution {
    public long solution(int n) {
        long[] dp = new long[n+1];
        
        dp[1] = 1L;
        if(n>1){
            dp[2] = 2L;
        }
        
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1])%1234567;
        }
        
        return dp[n];
    }
}