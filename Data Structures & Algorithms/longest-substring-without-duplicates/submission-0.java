class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;     
            }
            set.add(c);
            if(right - left + 1 > maxLength)
                maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
