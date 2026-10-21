class Solution {
    public boolean validTree(int n, int[][] edges) {
        //un arbore are exact n-1 muchii
        if(edges.length != n-1){
            return false;
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            result.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            result.get(u).add(v);
            result.get(v).add(u);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        visited.add(0);
        queue.add(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i: result.get(node)){
                if(!visited.contains(i)){
                    //nu mai e nevoie de verificare ciclu
                    //daca deja are n-1 muchii
                    queue.add(i);
                    visited.add(i);
                }
            }
        }
        return visited.size() == n;
    }
}
