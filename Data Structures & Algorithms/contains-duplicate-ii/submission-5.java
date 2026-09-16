class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < nums.length; right++){
            if(map.containsKey(nums[right]) && Math.abs(right - map.get(nums[right])) <= k)
                return true;
            map.put(nums[right], right);
        }
        return false;
    }
}