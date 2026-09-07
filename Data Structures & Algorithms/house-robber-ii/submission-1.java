class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int n = nums.length;
        int[] sumIncludeFirst = new int[n-1];
        int[] sumIncludeLast = new int[n-1];

        sumIncludeFirst[0] = nums[0];
        sumIncludeFirst[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n-1; i++){
            sumIncludeFirst[i] = Math.max(sumIncludeFirst[i-1], sumIncludeFirst[i-2] + nums[i]);
        }

        sumIncludeLast[0] = nums[1];
        sumIncludeLast[1] = Math.max(nums[1], nums[2]);
        for(int i=2; i<n-1; i++){
            sumIncludeLast[i] = Math.max(sumIncludeLast[i-1], sumIncludeLast[i-2] + nums[i+1]);
        }

        return Math.max(sumIncludeFirst[n-2], sumIncludeLast[n-2]);

    }
}
