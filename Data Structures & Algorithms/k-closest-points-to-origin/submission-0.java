class Solution {
    class Pair{
        int index, dist;
        public Pair(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> Integer.compare(b.dist, a.dist));
        for (int i = 0; i < points.length; i++){
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            Pair p = new Pair(i, dist);
            queue.add(p);
            if(queue.size() > k)
                queue.poll();
        }
        int[][] result = new int[queue.size()][2];
        int cnt = 0;
        while(!queue.isEmpty()){
            int index = queue.poll().index;
            result[cnt][0] = points[index][0];
            result[cnt][1] = points[index][1];
            cnt++;
        }
        return result;
        
    }
}
