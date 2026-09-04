class PrefixTree {
    class TrieNode{
        TrieNode[] children;
        boolean endWord;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.endWord = false;
        }
    }
    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.endWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null)
                return false;
            current = current.children[index];
        }
        return current.endWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c: prefix.toCharArray()){
            int index = c - 'a';
            if(current.children[index] == null)
                return false;
            current = current.children[index];
        }
        return true;
    }
}
