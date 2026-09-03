class Solution {
    public String minWindow(String s, String t) {
        int left = 0, need = 0, have = 0, minLength = Integer.MAX_VALUE, startIndex = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(char c: t.toCharArray()){
            if(tMap.containsKey(c)){
                tMap.put(c, tMap.get(c) + 1);
            }else{
                need++;
                tMap.put(c, 1);
            }
        }
        for(int right = 0; right < s.length(); right ++){
            char c = s.charAt(right);
            if(sMap.containsKey(c))
                sMap.put(c, sMap.get(c) + 1);
            else
                sMap.put(c, 1);
            if(tMap.containsKey(c) && sMap.get(c).equals(tMap.get(c)))
                have++;
            while(have == need){
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if(tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar))
                    have --;
                left++;
            }
        }
        if(minLength == Integer.MAX_VALUE)
            return "";
        return s.substring(startIndex, startIndex + minLength);
    }
    
}
