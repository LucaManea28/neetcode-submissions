class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites){
            graph[pre[0]].add(pre[1]);
            inDegree[pre[1]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> order = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            order.add(curr);
            for(int neigh: graph[curr]){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0){
                    queue.add(neigh);
                }
            }
        }
        if(order.size() == numCourses){
            return true;
        }
        return false;
    }
}
