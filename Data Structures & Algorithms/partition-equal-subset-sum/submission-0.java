class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        if(sum % 2 == 1){
            return false;
        }
        return possible(nums, sum/2, 0, 0);
    }
    private boolean possible(int[] nums, int target, int currSum, int i){
        if(currSum == target){
            return true;
        }
        if(i >= nums.length || currSum > target){
            return false;
        }
        return possible(nums, target, currSum + nums[i], i+1) || possible(nums, target, currSum, i+1);
    }
}
