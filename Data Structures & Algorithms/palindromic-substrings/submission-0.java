class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++){
            int count1 = extand(s, i, i);
            int count2 = extand(s, i, i+1);
            result += count1;
            result += count2;
        }
        return result;
    }
    private int extand(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
