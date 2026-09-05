class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
       List<Integer> curr = new ArrayList<>(); 
       backtracking(0, nums, curr);
       return result;
    }

    private void backtracking(int index, int[] nums, List<Integer> curr){
        if(index == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtracking(index+1, nums, curr);
        curr.remove(curr.size() - 1);
        backtracking(index+1, nums, curr);
    }
}
