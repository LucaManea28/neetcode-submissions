class Solution {
    public int longestConsecutive(int[] nums) {
       if(nums.length == 0){
            return 0;
       }
       if(nums.length == 1){
            return 1;
       }
       int maxLen = 1;
       Set<Integer> set = new HashSet<>();
       for(int num: nums){
            set.add(num);
       }
       for(int i=0; i<nums.length; i++){
            int start = nums[i];
            int cnt = 1;
            if(!set.contains(start - 1)){
                while(set.contains(start + 1)){
                    start = start+1;
                    cnt++;
                }
                maxLen = Math.max(maxLen, cnt);
            }
       }
       return maxLen;
    }
}
