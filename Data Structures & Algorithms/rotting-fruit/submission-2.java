class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int freshFruits = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c] == 1){
                    freshFruits++;
                }else if(grid[r][c] == 2){
                    queue.add(new int[]{r,c});
                }
            }
        }
        int time = 0;
        int[][] directions = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        while(!queue.isEmpty() && freshFruits > 0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                for(int[] dir: directions){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r< rows && c >= 0 && c < cols){
                        if(grid[r][c] == 1){
                            freshFruits--;
                            grid[r][c] = 2;
                            queue.add(new int[]{r,c});
                        }
                    }
                }
            }
            time++;
        }
        if(freshFruits > 0)
            return -1;
        return time;
    }
}
