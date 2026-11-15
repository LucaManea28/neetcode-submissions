class Solution {
    public int rob(int[] nums) {
       if(nums.length == 1){
            return nums[0];
       }
       if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
       }
       int n = nums.length;
       int max1 = helper(nums, 0, n-2);
       int max2 = helper(nums, 1, n-1);
       return Math.max(max1, max2);
    }
    private int helper(int[] nums, int start, int end){
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start+1]);
        for(int i=start+2; i<=end; i++){
            int profit = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = profit;
            
        }
        return prev1;
    }
    
}
