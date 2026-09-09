class Solution {
    public boolean validPalindrome(String s) {
        int tryies = 1, left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return helperFunction(s, left+1, right) || helperFunction(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean helperFunction(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}