class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] f: flights){
            int start = f[0];
            int end = f[1];
            int price = f[2];
            graph[start].add(new int[]{end, price});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        int stops = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{src, 0});
        while(!queue.isEmpty() && stops <= k){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                int currNode = curr[0];
                int currPrice = curr[1];
                for(int[] next: graph[currNode]){
                    int nextNode = next[0];
                    int nextPrice = next[1];
                    if(nextPrice + currPrice < dist[nextNode]){
                        dist[nextNode] = nextPrice + currPrice;
                        queue.add(new int[]{nextNode, dist[nextNode]});
                    }
                }
            }
            stops++;
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}
