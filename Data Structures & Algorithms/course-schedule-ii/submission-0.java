class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites){
            int start = pre[1];
            int end = pre[0];
            //!! aici e un pic invers logica
            graph[start].add(end);
            inDegree[end]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result[index++] = curr;
            for(int neigh: graph[curr]){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0){
                    queue.add(neigh);
                }
            }
        }
        if(index == numCourses){
            return result;
        }
        return new int[0];
    }
}
