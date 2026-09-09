class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int right = 1; right < nums.length; right++){
            if(map.containsKey(nums[right])){
                if(right - map.get(nums[right]) <= k)
                    return true;
            }
            map.put(nums[right], right);
        }
        return false;
    }
}