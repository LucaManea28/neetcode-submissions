class Solution {
    public List<Integer> partitionLabels(String s) {
        //nu e o idee buna cu freq pentru ca nu stiu cat de mult sa inaintez cu partita curent
        //daca gasesc un x, atunci adug la partitie pana cand nu mai am x, dar trebuie sa o mai prelunges si cu elementele adugate pana la ultimul x, daca mai adug si altele
        //de accea un approch mai bun ar fi sa pasterz ultima apartie a fiecarei litere si sa tot inaintez
        int[] lastIndex = new int[26];
        List<Integer> result = new ArrayList<>();
        Arrays.fill(lastIndex, -1);
        for(int i = s.length() - 1; i >= 0; i--){
            if(lastIndex[s.charAt(i) - 'a'] == -1){
                lastIndex[s.charAt(i) - 'a'] = i;
            }
        }
        int currEnd = 0;
        int currStart = 0;
        for(int i=0; i<s.length(); i++){
            if(lastIndex[s.charAt(i) - 'a'] > currEnd){
                currEnd = lastIndex[s.charAt(i) - 'a'];
            }
            if(currEnd == i){
                result.add(currEnd - currStart + 1);
                currEnd = i+1;
                currStart = i+1;
            }
        }
        return result;
    }
}
