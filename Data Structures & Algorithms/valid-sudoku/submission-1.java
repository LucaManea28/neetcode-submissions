class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<9; i++){
            set.clear();
            for(int j=0; j<9; j++){
                if(board[i][j] != '.' && set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        for(int j=0; j<9; j++){
            set.clear();
            for(int i=0; i<9; i++){
                if(board[i][j] != '.' && set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        for(int box=0; box<9; box++){
            set.clear();
            int startRow = (box/3) * 3;
            int startCol = (box%3) * 3;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    char c = board[startRow + i][startCol + j];
                    if(c != '.' && set.contains(c))
                        return false;
                    set.add(c);
                }
            }
        }
        return true;
    }
}
