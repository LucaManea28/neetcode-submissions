class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        for(int i=0; i<n; i++){
            if(i > maxReach){
                return false;
            }
            //am optiunea sa sar oricat in intervalul [0, nums[i]] pentru fiecare element, de aia aleg sa tin doar big bound-ul aici
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
