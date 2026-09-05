class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, curr, 0);
        return result;
    }
    private void backtrack(int[] candidates, int target, List<Integer> curr, int index){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        //cu set pica la teste
        for(int i=index; i<candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1])
                continue;
            if(candidates[i] > target)
                break;
            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], curr, i+1);
            curr.remove(curr.size() - 1);
        }
    }
}
