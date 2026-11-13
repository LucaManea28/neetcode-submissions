class Solution {
    public int majorityElement(int[] nums) {
        //hash Map -> O(n) space
        //can be done in O(1) space
        int score = 0, candidate = 0;
        for(int num: nums){
            if(score == 0){
                candidate = num;
                score = 1;
            }else if(num == candidate){
                score++;
            }else{
                score--;
            }
        }
        return candidate;
    }
}