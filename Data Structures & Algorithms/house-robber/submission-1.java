class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            sum[i] = Math.max(nums[i] + sum[i-2], sum[i-1]);
        }
        return sum[nums.length - 1];
    }
}
