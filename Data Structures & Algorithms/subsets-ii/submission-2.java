class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        back(nums, curr, 0);
        return result;
    }
    private void back(int[] nums, List<Integer> curr, int index){
        result.add(new ArrayList<>(curr));
        for(int i=index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1])
                continue;
            curr.add(nums[i]);
            back(nums, curr, i+1);
            curr.remove(curr.size() - 1);
        }
        
    }
}
