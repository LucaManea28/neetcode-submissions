class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0, left = 0, maxFreq = 0;
        int[] freq = new int[26];
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            freq[c - 'A']++;
            if(maxFreq < freq[c - 'A'])
                maxFreq = freq[c - 'A'];
            if(right - left + 1 - maxFreq > k){
                char leftChar = s.charAt(left);
                freq[leftChar - 'A'] --;
                left++;
            }else{
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
