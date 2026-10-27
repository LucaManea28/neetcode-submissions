class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<n; i++){
            //j can become bigger than n!!!
            for(int j=i+1; j<=i+nums[i] && j<n; j++){
                if(dp[j] == Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
                if(j == n-1){
                    return dp[j];
                }
            }
        }
        return dp[n-1];
    }
}
