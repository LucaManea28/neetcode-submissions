class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int left = 0, maxLen = 1;
        for(int right = 1; right < n; right++){
            if(arr[right-1] == arr[right]){
                //daca doua elemenete consecutive sunt egale, turbulenta se rupe complet
                left = right;
            }else if(right > 1 && (arr[right-2] < arr[right-1]) == (arr[right-1] < arr[right])){
                //doua comparatii merg in ac. directie
                //de la penultimul element deoarece ultima comparatie poate face parte dintr-o secventa valida
                left = right - 1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}