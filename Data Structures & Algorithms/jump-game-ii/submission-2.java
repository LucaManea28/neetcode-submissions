class Solution {
    public int jump(int[] nums) {
        int maxJump = nums[0];
        int currEnd = 0;
        int jumps = 0;
        for(int i=0; i<nums.length-1; i++){
           maxJump = Math.max(maxJump, nums[i] + i);
           if(i == currEnd){
                currEnd = maxJump;
                jumps++;
           }
        }
        return jumps;
    }
}
