class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String op: operations){
            if(op.equals("+")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2);
                stack.push(temp1);
                stack.push(temp1 + temp2);
            }else if(op.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(op.equals("C")){
                stack.pop();
            }else{
                int a = Integer.parseInt(op);
                stack.push(a);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

}