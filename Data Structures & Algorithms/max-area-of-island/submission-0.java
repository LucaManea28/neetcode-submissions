class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int size = 0;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c] == 1){
                    size = Math.max(size, explore(grid, r, c, rows, cols));
                }
            }
        }
        return size;
    }
    private int explore(int[][] grid, int r, int c, int rows, int cols){
        int[][] directions = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        Queue<int[]> queue = new ArrayDeque<>();
        int cnt = 1;
        queue.add(new int[]{r, c});
        grid[r][c] = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir: directions){
                int new_r = curr[0] + dir[0];
                int new_c = curr[1] + dir[1];
                if(new_r >= 0 && new_r< rows && new_c >= 0 && new_c < cols){
                    if(grid[new_r][new_c] == 1){
                        queue.add(new int[]{new_r,new_c});
                        cnt++;
                        grid[new_r][new_c] = 0;
                    }
                }
            }
        }
        return cnt;
    }
}
