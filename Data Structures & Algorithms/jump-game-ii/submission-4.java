class Solution {
    public int jump(int[] nums) {
        //greedy approach
        int n = nums.length;
        int currEnd = 0;
        int maxJump = 0;
        int jumps = 0;
        for(int i=0; i<n-1; i++){
            maxJump = Math.max(maxJump, nums[i] + i);
            if(i == currEnd){
                currEnd = maxJump;
                jumps++;
            }
        }
        return jumps;
    }
}
