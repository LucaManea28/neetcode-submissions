class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String s: strs){
            result.append(s.length()).append("*").append(s);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(Character.isDigit(str.charAt(j)))
                j++;
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            result.add(str.substring(j, j+length));
            i = j+length;
        }
        return result;

    }
}
