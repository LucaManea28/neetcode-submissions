class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(); //O(n)
        for(int i=0; i<=edges.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            Set<Integer> visited = new HashSet<>(); //pt fiecare muchie trebuie O(n)
            boolean alreadyConnected = dfs(adj, u, v, visited);
            if(alreadyConnected){
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{-1, -1};
    }
    private boolean dfs(List<List<Integer>> adj, int start, int end, Set<Integer> visited){
        if(start == end){
            return true;
        }
        visited.add(start);
        for(int neighbor: adj.get(start)){
            if(!visited.contains(neighbor)){
                if(dfs(adj, neighbor, end, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
