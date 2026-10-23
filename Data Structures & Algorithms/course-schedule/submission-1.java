class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p: prerequisites){
            adj.get(p[1]).add(p[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<numCourses; i++){
            if(hasCycle(i, adj, visited)){
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(int curr, List<List<Integer>> adj, Set<Integer> visited){
        if(visited.contains(curr)){
            return true;
        }
        visited.add(curr);
        for(int i: adj.get(curr)){
            if(hasCycle(i, adj, visited)){
                return true;
            }
        }
        visited.remove(curr);
        adj.get(curr).clear();
        return false;
    }
}
