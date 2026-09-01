class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);

        }
        stack.clear(); //pt a o refolosi
        for(int i=heights.length-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int area = heights[i] * (right[i] - left[i] - 1);
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}
