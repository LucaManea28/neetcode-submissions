class Solution {
    int totalSum = 0;
    public int subsetXORSum(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        back(curr, nums, 0);
        return totalSum;
    }
    private void back(List<Integer> curr, int[] nums, int index){
        int currXor = 0;
        for(int i: curr){
            currXor ^= i;
        }
        totalSum += currXor;
        for(int i=index; i<nums.length; i++){
            curr.add(nums[i]);
            back(curr, nums, i+1);
            curr.remove(curr.size() - 1);
        }
    }
}