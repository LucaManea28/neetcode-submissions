class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       int left = 0, right = arr.length - 1;
       while(right - left >= k){
            int leftDist = Math.abs(x - arr[left]);
            int rightDist = Math.abs(x - arr[right]);
            if(leftDist > rightDist)
                left++;
            else 
                right--;
       }
       List<Integer> result = new ArrayList<>();
       for(int i=left; i<=right; i++)
          result.add(arr[i]);
       return result;
    }
}