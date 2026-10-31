class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int left = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            int currLen = right - left + 1;
            if(currLen - maxFreq > k){
                char leftChar = s.charAt(left);
                if(freq[leftChar - 'A'] > 0){
                    if(maxFreq == freq[leftChar - 'A']){
                        maxFreq--;
                    }
                    freq[leftChar - 'A']--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
