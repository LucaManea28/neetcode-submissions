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
            if(curr.children[index] == null)    
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.endWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    private boolean searchHelper(String word, int index, TrieNode curr){
        for(int i = index; i<word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child: curr.children){
                    if(child != null && searchHelper(word, i+1, child))
                        return true;
                }
                return false;
            }else{
                int charIndex = c - 'a';
                if(curr.children[charIndex] == null)
                    return false;
                curr = curr.children[charIndex];
            }
        }
        return curr.endWord;
    }
}
