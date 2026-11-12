class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] time: times){
            int start = time[0];
            int end = time[1];
            int dist = time[2];
            graph[start].add(new int[]{end, dist});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        dist[k] = 0;
        pq.add(new int[]{k, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];
            if(currDist > dist[currNode]){
                continue;
            }
            for(int[] next: graph[currNode]){
                int nextNode = next[0];
                int nextDist = next[1];
                if(nextDist + currDist < dist[nextNode]){
                    dist[nextNode] = nextDist + currDist;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        int maxDist = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }
}
