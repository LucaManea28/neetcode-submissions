class Solution {
    class UnionFind{
        int[] parent;
        int[] size;
        int comp;
        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            comp = n;
            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x){
            if(x == parent[x]){
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }
        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)
                return false;
            int sizeX = size[rootX];
            int sizeY = size[rootY];
            if(sizeX > sizeY){
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }else{
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            comp--;
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        List<int[]> edges = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dist});
            }
        }
        Collections.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));
        int totalCost = 0;
        int edgeUsed = n-1; //un arbore (fara cicluri) are n-1 muchii
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if(uf.union(u,v)){
                edgeUsed--;
                totalCost += weight;
                if(edgeUsed == 0){
                    break;
                }
            }
        }
        return totalCost;
    }
}
