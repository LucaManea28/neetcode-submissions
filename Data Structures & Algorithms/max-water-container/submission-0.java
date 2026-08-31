class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(left < right){
            int length = right - left;
            int area = length * Math.min(heights[left], heights[right]);
            if(area > maxArea)
                maxArea = area;
            if(heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
