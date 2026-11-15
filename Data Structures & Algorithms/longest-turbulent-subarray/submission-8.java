class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxLen = 1;
        int left = 0;
        for(int right = 1; right < arr.length; right++){
            if(arr[right-1] == arr[right]){
                left = right;
            }else if(right > 1 && ((arr[right-2] < arr[right-1]) == (arr[right-1] < arr[right]))){
                left = right - 1;
            }       
            maxLen = Math.max(maxLen, right - left + 1);      
        }
        return maxLen;
    }
}