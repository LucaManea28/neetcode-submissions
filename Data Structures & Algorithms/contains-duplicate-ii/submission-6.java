class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       int left = 0;
       Set<Integer> set = new HashSet<>();
       for(int right = 0; right < nums.length; right++){
        if(set.contains(nums[right])){
            return true;
        }
        set.add(nums[right]);
        if(right - left + 1 > k){
            set.remove(nums[left]);
            left++;
        }
        
       }
       return false;
    }
}