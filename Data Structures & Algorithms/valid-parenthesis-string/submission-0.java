class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        //facem asa pentru ca nu stim ce reprezinta *
        //ar mai fi si o varianta in care luam doua stive, deci O(n) spatiu, si daca e ( atunci adauga in stiva 1, altfel, daca e * adaugam in stiva 2, si daca e ) atunci incercam sa scoate din s1, daca nu putem, scoatem din s2.
        for(char c: s.toCharArray()){
            if(c == '('){
                low++;
                high++;
            }else if(c == ')'){
                low--;
                high--;
            }else{
                low--; //nr minim de paranteze ( care nu au fost inchide
                high++; //nr maxim -||-
            }
            if(high < 0){
                return false;
            }
            if(low < 0){
                low = 0;
            }
        }
        return low == 0;
    }
}
