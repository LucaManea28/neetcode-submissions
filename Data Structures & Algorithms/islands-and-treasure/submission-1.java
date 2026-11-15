class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0){
            return;
        }
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int currDist = 1;
        int[][] directions = {{-1, 0}, {1,0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] dir: directions){
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if(newR >= 0 && newR < m && newC >= 0 && newC < n){
                        if(grid[newR][newC] == Integer.MAX_VALUE){
                            grid[newR][newC] = currDist;
                            queue.add(new int[]{newR, newC});
                        }
                    }
                }
            }
            currDist++;
        }
    }
    
}
