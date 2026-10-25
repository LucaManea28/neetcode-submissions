class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        for(int n: nums){
            total += n;
        }
        int maxSum = nums[0], currMaxSum = nums[0];
        int minSum = nums[0], currMinSum = nums[0];
        for(int i=1; i<nums.length; i++){
            currMaxSum = Math.max(nums[i], currMaxSum + nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = Math.min(nums[i], currMinSum + nums[i]);
            minSum = Math.min(minSum, currMinSum);
        }
        if(maxSum < 0){
            return maxSum; //toate nr sunt negative si atunci total - minSum = 0 (caz special)
        }
        return Math.max(maxSum, total - minSum);
    }
}