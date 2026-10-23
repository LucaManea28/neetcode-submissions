class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;
        int[][] directions = {{-1,0}, {0,-1}}; //above and left right
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c] == 1){
                    perimeter += 4;
                    for(int[] dir: directions){
                        int new_r = r + dir[0];
                        int new_c = c + dir[1];
                        if(new_r >= 0 && new_r < rows && new_c >= 0 && new_c < cols){
                            if(grid[new_r][new_c] == 1){
                                perimeter -= 2;
                            }
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}