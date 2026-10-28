class Solution {
    public String longestCommonPrefix(String[] strs) {
        String reper = strs[0];
        for(int pos = 0; pos < reper.length(); pos++){
            for(int i=1; i<strs.length; i++){
                if(pos >= strs[i].length() || strs[i].charAt(pos) != reper.charAt(pos)){
                    return reper.substring(0, pos);
                }
            }
        }
        return reper;
    }
}