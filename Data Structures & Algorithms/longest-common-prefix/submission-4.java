class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String prefix = strs[0];
        for(int index=0; index<prefix.length(); index++){
            char c = prefix.charAt(index);
            for(int i=1; i<strs.length; i++){
                if(index >= strs[i].length() || strs[i].charAt(index) != c)
                    return prefix.substring(0, index);
            }
        }
        return prefix;
    }
}