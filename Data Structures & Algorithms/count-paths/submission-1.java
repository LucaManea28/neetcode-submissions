class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        //for first row we can come only from left
        for(int j=0; j<n; j++){
            dp[j] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[j] = dp[j-1] + dp[j];
            }
            
            //dp[i-1] value from left
            //dp[i] last value from above if exists, other 0 
        }
        return dp[n-1];
    }
}
