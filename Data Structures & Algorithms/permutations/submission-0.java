class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, curr, used);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> curr, boolean[] used){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i])
                continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums, curr, used);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
