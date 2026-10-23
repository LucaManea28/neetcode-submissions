class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int c=0; c<cols; c++){
            if(board[0][c] == 'O')
                bfs(board, 0, c, rows, cols);
            if(board[rows-1][c] == 'O')
                bfs(board, rows-1, c, rows, cols);
        }
        for(int r=0; r<rows; r++){
            if(board[r][0] == 'O')
                bfs(board, r, 0, rows, cols);
            if(board[r][cols-1] == 'O')
                bfs(board, r, cols-1, rows, cols);
        }
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(board[r][c] == 'O')
                    board[r][c] = 'X';
                else if(board[r][c] == 'S')
                    board[r][c] = 'O';
            }
        }
    }
    private void bfs(char[][] board, int r, int c, int rows, int cols){
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        queue.add(new int[]{r, c});
        board[r][c] = 'S';
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                for(int[] dir: directions){
                    int new_r = curr[0] + dir[0];
                    int new_c = curr[1] + dir[1];
                    if(new_r >= 0 && new_r < rows && new_c >= 0 && new_c < cols){
                        if(board[new_r][new_c] == 'O'){
                            board[new_r][new_c] = 'S';
                            queue.add(new int[]{new_r, new_c});
                        }   
                    }
                }
            }
        }
    }
}
