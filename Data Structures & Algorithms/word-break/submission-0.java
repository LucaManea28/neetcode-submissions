class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                String word = s.substring(j, i);
                if(dp[j] && isList(word, wordDict)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    private boolean isList(String s, List<String> dict){
        for(String word: dict){
            if(s.equals(word)){
                return true;
            }
        }
        return false;
    }
}
