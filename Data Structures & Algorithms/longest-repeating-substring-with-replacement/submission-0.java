class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0, maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(!map.containsKey(c))
                map.put(c, 1);
            else{
                map.put(c, map.get(c) + 1);
            }
            maxFreq = Math.max(maxFreq, map.get(c));
            if(right - left + 1 - maxFreq > k){
                int freq = map.get(s.charAt(left)) - 1;
                map.put(s.charAt(left), freq);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
