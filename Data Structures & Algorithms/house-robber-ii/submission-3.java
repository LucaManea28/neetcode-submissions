class Solution {
    public int rob(int[] nums) {
       if(nums.length == 1){
        return nums[0];
       }
       if(nums.length == 2){
        return Math.max(nums[0], nums[1]);
       }
       int case1 = rob(nums, 0, nums.length - 2);
       int case2 = rob(nums, 1, nums.length - 1);
       return Math.max(case1, case2);
    }
    private int rob(int[] nums, int start, int end){
        if(nums.length == 1){
            return nums[start];
        }
        if(nums.length == 2){
            return Math.max(nums[start], nums[start+1]);
        }
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start+1]);
        for(int i=start+2; i<=end; i++){
            int curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    
}
