class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0){
            return;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] == 0){
                    queue.add(new int[]{r,c});
                }
            }
        }
        modify(grid, m, n, queue);
    }
    private void modify(int[][] grid, int rows, int cols, Queue<int[]> queue){
        int[][] directions = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        int road = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                for(int[] dir: directions){
                    int new_r = curr[0] + dir[0];
                    int new_c = curr[1] + dir[1];
                    if(new_r >= 0 && new_r < rows && new_c >= 0 && new_c < cols){
                        if(grid[new_r][new_c] == Integer.MAX_VALUE){
                            grid[new_r][new_c] = road;
                            queue.add(new int[]{new_r, new_c});
                        }
                    }
                }
            }
            road++;
        }
    }
}
