class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        if(grid == null || grid.length == 0){
            return 0;
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid, i, j, grid.length, grid[0].length);
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int r, int c, int rows, int cols){
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r-1, c, rows, cols);
        dfs(grid, r+1, c, rows, cols);
        dfs(grid, r, c-1, rows, cols);
        dfs(grid, r, c+1, rows, cols);
    }
}
