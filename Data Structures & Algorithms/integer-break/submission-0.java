class Solution {
    public int integerBreak(int n) {
        //dp[i] = prod maxim pe care il putem obtine spargand numarul i
        int[] dp = new int[n+1];
        for(int i=2; i<=n; i++){
            //nu pot sparge 0 si 1, de aia incep de la 2
            for(int j=1; j<i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j*dp[i-j]));
                //ideea e ca atunc cand sparg am 2 parti: j si i-j
                //ori merg pe asta, ori mai sparg o data i-j si ma folosesc tot de dp ca sa gasesc raspunsul, adica dp[i-j];
            }
        }
        return dp[n];
    }
}