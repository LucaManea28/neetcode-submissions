class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean endWord;
        public TrieNode(){
            children = new TrieNode[26];
            endWord = false;
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.endWord = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    private boolean dfs(TrieNode root, String word, int index){
        if(index == word.length()){
            return root.endWord;
        }
        char c = word.charAt(index);
        if(c == '.'){
            for(int i=0; i<26; i++){
                if(root.children[i] != null && dfs(root.children[i], word, index+1)){
                    return true;
                }
            }
            return false;
        }else{
            int pos = c - 'a';
            if(root.children[pos] == null){
                return false;
            }
            return dfs(root.children[pos], word, index+1);
        }
    }
    
}
