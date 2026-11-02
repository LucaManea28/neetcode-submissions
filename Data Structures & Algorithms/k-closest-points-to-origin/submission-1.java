class Solution {
    class Point{
        int x, y;
        double dist;
        public Point(int x, int y, double dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<>((a,b) -> Double.compare(b.dist, a.dist));
        for(int[] p: points){
            double dist = Math.sqrt(p[0]*p[0] + p[1]*p[1]);
            heap.add(new Point(p[0], p[1], dist));
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        while(!heap.isEmpty()){
            result[i][0] = heap.peek().x;
            result[i][1] = heap.peek().y;
            i++;
            heap.poll();
        }
        return result;
        
    }
}
