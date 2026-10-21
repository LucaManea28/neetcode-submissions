class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int components = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                components++;
                dfs(adj, visited, i);
            }
        }
        return components;
    }
    private void dfs(List<List<Integer>> adj, boolean[] visited, int current){
        visited[current] = true;
        for(int i: adj.get(current)){
            if(!visited[i]){
                dfs(adj, visited, i);
            }
        }
    }
}
