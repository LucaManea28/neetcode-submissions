class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //primul rand si prima coloana sunt 0
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //verificam caracterele curente, dar atentie la indexare
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Dacă avem match, extindem LCS-ul anterior
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Dacă nu, propagăm valoarea maximă găsită până acum pe una din ramuri
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Răspunsul final se află în colțul dreapta-jos al matricei
        return dp[m][n];
    }
}
