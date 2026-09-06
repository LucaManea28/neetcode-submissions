class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        //cuvantul poate incepe de oriunde
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(back(board, word, i, j, visited, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean back(char[][] board, String word, int i, int j, boolean[][] visited, int index){
        if(index == word.length())
            return true;
        if(i < 0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || board[i][j] != word.charAt(index))
            return false;
        visited[i][j] = true;
        boolean found = 
        back(board, word, i+1, j, visited, index+1) ||          
        back(board, word, i-1, j, visited, index+1) ||
        back(board, word, i, j+1, visited, index+1) ||
        back(board, word, i, j-1, visited, index+1);
        visited[i][j] = false;
        return found;
    }
}
