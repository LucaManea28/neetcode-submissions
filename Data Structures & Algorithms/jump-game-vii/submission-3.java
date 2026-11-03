class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                dp[i] = false;
            }else{
                for(int j=0; j<i; j++){
                    if(j + minJump <= i && j + maxJump >= i){
                        if(dp[j]){
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}