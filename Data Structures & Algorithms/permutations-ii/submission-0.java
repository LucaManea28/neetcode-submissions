class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        back(curr, nums, visited);
        return result;
    }
    private void back(List<Integer> curr, int[] nums, boolean[] visited){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i])
                continue; 
            //daca elementul anterior (care e si egal cu cel curent), NU a fost folosit anterior, atunci nici cel curent nu ar trebui utilizat
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1])
                continue;
            visited[i] = true;
            curr.add(nums[i]);
            back(curr, nums, visited);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}