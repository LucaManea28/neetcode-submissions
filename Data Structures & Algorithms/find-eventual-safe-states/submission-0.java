class Solution {
    public int[] eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] invertedGraph = new ArrayList[n];
        for(int i=0; i<n; i++){
            invertedGraph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            int newEnd = i;
            for(int j=0; j<graph[i].length; j++){
                int newStart = graph[i][j]; 
                invertedGraph[newStart].add(newEnd);
                inDegree[newEnd]++;
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        boolean[] isSafe = new boolean[n];
        int safeCount = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            isSafe[curr] = true;
            safeCount++;
            for(int neigh: invertedGraph[curr]){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0){
                    queue.add(neigh);
                }
            }
        }
        int[] result = new int[safeCount];
        int index = 0;
        for(int i=0; i<n; i++){
            if(isSafe[i]){
                result[index++] = i;
            }
        }
        return result;
    }
}
