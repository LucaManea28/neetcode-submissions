class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i=0; i<n; i++){
            if(!dp[i]) continue;
            for(int j = i+minJump; j<=i+maxJump && j<n; j++){
                if(s.charAt(j) == '0'){
                    dp[j] = true;
                }

            }
        }
        return dp[n-1];
    }
}