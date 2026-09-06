class Solution {
    public int majorityElement(int[] nums) {
        //hash Map -> O(n) space
        //can be done in O(1) space
        int candidate = 0;
        int count = 0;
        for(int i: nums){
            if(count == 0)
                candidate = i;
            if(i == candidate)
                count++;
            else    
                count--;
        }
        return candidate;
    }
}