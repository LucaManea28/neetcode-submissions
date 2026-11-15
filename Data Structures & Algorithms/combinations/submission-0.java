class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        back(curr, n, k, 1);
        return result;
    }
    private void back(List<Integer> curr, int n, int k, int index){
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index; i<=n; i++){
            curr.add(i);
            back(curr, n, k, i+1);
            curr.remove(curr.size() - 1);
        }
    }
}