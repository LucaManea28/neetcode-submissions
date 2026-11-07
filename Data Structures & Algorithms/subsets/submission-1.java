class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
       List<Integer> curr = new ArrayList<>(); 
       backtracking(0, nums, curr);
       return result;
    }

    private void backtracking(int startIndex, int[] nums, List<Integer> curr){
        result.add(new ArrayList<>(curr));
        for(int i=startIndex; i<nums.length; i++){
            curr.add(nums[i]);
            backtracking(i + 1, nums, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
