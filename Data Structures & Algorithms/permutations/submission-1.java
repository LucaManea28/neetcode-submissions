class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(result, curr, nums, used);
        return result;
    }
    private void backtracking(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] used){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtracking(result, curr, nums, used);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
    
}
