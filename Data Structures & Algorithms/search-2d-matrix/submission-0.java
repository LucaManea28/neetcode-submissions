class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //we can see the matrix as a sorted array
        //firstly we search which row is the range that apply bs on that one
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            if(matrix[i][0] <= target && matrix[i][n-1] >= target){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left)/2;
            if(nums[middle] == target)
                return true;
            else if(nums[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return false;
    }
}
