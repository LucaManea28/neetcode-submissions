class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if(heights == null || heights.length == 0)
            return result;
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] p = new boolean[rows][cols];
        boolean[][] a = new boolean[rows][cols];
        for(int c=0; c<cols; c++){
            dfs(heights, p, 0, c, rows, cols, heights[0][c]);
            dfs(heights, a, rows-1, c, rows, cols, heights[rows-1][c]);
        }
        for(int r=0; r<rows; r++){
            dfs(heights, p, r, 0, rows, cols, heights[r][0]);
            dfs(heights, a, r, cols-1, rows, cols, heights[r][cols-1]);
        }
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(a[r][c] && p[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, boolean[][] ocean, int r, int c, int rows, int cols, int prevHeight){
        if(r<0 || r>=rows || c<0 || c>=cols || ocean[r][c] || heights[r][c] < prevHeight){
            return;
        }
        ocean[r][c] = true;
        dfs(heights, ocean, r-1, c, rows, cols, heights[r][c]);
        dfs(heights, ocean, r+1, c, rows, cols, heights[r][c]);
        dfs(heights, ocean, r, c-1, rows, cols, heights[r][c]);
        dfs(heights, ocean, r, c+1, rows, cols, heights[r][c]);
    }
}
