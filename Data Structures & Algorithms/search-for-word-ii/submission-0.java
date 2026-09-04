class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        char c = board[i][j];
        int index = c - 'a';
        if(node.children[index] == null)
            return;
        node = node.children[index];
        if(node.word != null){
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, node, result);
        dfs(board, i + 1, j, node, result);
        dfs(board, i, j - 1, node, result);
        dfs(board, i, j + 1, node, result);
        board[i][j] = c;
    }
    private TrieNode buildTrie(String[] word){
        TrieNode root = new TrieNode();
        for(String w: word){
            TrieNode curr = root;
            for(char c: w.toCharArray()){
                int index = c - 'a';
                if(curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                curr = curr.children[index];
            }
            curr.word = w;
        }
        return root;
    }
}
