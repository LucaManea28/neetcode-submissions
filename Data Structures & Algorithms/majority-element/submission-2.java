class Solution {
    public int majorityElement(int[] nums) {
        //hash Map -> O(n) space
        //can be done in O(1) space
        int candidate = nums[0];
        int score = 1;
        for(int i=1; i<nums.length; i++){
            if(score == 0){
                candidate = nums[i];
                score++;
            }else if(nums[i] == candidate){
                score++;
            }else{
                score--;
            }
        }
        return candidate;
    }
}