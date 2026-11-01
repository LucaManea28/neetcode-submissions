class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int k = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<asteroids.length; i++){
            if(asteroids[i] > 0){
                stack.push(asteroids[i]);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroids[i]) > stack.peek()){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroids[i]) == stack.peek()){
                        stack.pop();
                }else if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] result = new int[stack.size()];
        while(!stack.isEmpty()){
            result[k++] = stack.removeLast();
        }
        return result;
    }
}