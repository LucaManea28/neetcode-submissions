class MinStack {
    class Node{
        int value;
        int minim;
        public Node(int v, int m){
            this.value = v;
            this.minim = m;
        }
    }
    
    Deque<Node> stack;
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Node(val, val));
        }else{
            int minEl = stack.peek().minim;
            if(val > minEl){
                stack.push(new Node(val, minEl));
            }else{
                stack.push(new Node(val, val));
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
       return stack.peek().minim;
    }
}
