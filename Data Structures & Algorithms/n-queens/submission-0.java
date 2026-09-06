class Solution {
    List<List<String>> result = new ArrayList<>();
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                board[i][j] = '.';
        }
        back(board, 0);
        return result;
    }
    private void back(char[][] board, int row){
        if(row == board.length){
            result.add(construct(board));
            return;
        }
        for(int col=0; col<board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                back(board, row + 1);
                board[row][col] = '.';
            }
        }
    }
    //verificam doar deasupra (coloana, diagonale)
    private boolean isSafe(char[][] board, int row, int col){
        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q') return false;
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if(board[i][j] == 'Q')
                return false;
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }   

    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            res.add(new String(board[i]));
        }
        return res;
    }
}
