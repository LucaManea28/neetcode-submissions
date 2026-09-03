class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int left = 0;
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        for(char c: s1.toCharArray()){
            int index = c - 'a';
            s1Freq[index] ++;
        }
        for(int right = 0; right < s2.length(); right++){
            char c = s2.charAt(right);
            s2Freq[c - 'a'] ++;
            if(right - left + 1 > s1.length()){
                char leftChar = s2.charAt(left);
                s2Freq[leftChar - 'a'] --;
                left++;
            }
            if(right - left + 1 == s1.length()){
                if(Arrays.equals(s2Freq, s1Freq))
                    return true;
            }
        }
        return false;
    }
}
