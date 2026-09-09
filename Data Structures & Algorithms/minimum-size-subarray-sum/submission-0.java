class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE, sum = 0;
        int left = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                minLength = Math.min(minLength, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        if(minLength == Integer.MAX_VALUE)
            return 0;
        return minLength;
    }
}