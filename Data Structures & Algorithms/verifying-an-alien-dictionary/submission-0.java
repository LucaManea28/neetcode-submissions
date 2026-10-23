class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        int cnt = 0;
        for(char l: order.toCharArray()){
            rank[l - 'a'] = cnt++;
        }
        for(int i=0; i<words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            boolean findDif = false;
            for(int j=0; j<minLen; j++){
               int rank1 = rank[w1.charAt(j) - 'a'];
               int rank2 = rank[w2.charAt(j) - 'a'];
               if(rank1 > rank2){
                return false;
               }else if(rank1 < rank2){
                    findDif = true;
                    break;
               }
            }
            if(!findDif && w1.length() > w2.length()){
                    return false;
               }
        }
        return true;
    }
}