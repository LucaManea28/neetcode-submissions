class Solution {
    List<String> result = new ArrayList<>();
    String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty())
            return result;
        StringBuilder curr = new StringBuilder();
        back(digits, curr, 0);
        return result;
    }
    void back(String digits, StringBuilder curr, int index){
        if(index == digits.length()){
            result.add(curr.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        for(int i=0; i<phone[digit].length(); i++){
            curr.append(phone[digit].charAt(i));
            back(digits, curr, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
