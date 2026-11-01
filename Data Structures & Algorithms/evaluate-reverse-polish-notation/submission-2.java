class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String t: tokens){
            if(t.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            }else if(t.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }else if(t.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            }else if(t.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else{
                int a = Integer.parseInt(t.substring(0, t.length()));
                stack.push(a);
            }
        }
        return stack.pop();
    }
}
