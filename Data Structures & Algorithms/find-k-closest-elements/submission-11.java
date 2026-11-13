class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while(right - left + 1 > k){
            if(Math.abs(x - arr[left]) > Math.abs(x - arr[right])){
                left++;
            }else{
                right--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=left; i<=right; i++){
            list.add(arr[i]);
        }
        return list;
    }
}