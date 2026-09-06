class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<>();
        back(s, curr, 0);
        return result;
    }
    private void back(String s, List<String> curr, int startIndex){
        if(startIndex == s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=startIndex; i<s.length(); i++){
            if(isPalindrom(s,startIndex, i)){
                curr.add(s.substring(startIndex, i+1));
                back(s, curr, i+1);
                curr.remove(curr.size() - 1);
            }
        }
        
    }
    private boolean isPalindrom(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
