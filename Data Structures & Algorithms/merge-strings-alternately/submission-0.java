class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i1=0, i2=0;
        while(i1 < word1.length() && i2 <word2.length()){
            result.append(word1.charAt(i1)).append(word2.charAt(i2));
            i1++; i2++;
        }
        while(i1 < word1.length()){
             result.append(word1.charAt(i1));
             i1++;
        }
        while(i2 < word2.length()){
             result.append(word2.charAt(i2));
             i2++;
        }
        return result.toString();
    }
}