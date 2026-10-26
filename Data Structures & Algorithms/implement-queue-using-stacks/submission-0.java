class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int peek = 0;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
       s1.push(x);
    }
    
    public int pop() {
       while(s1.size() > 1){
            int value = s1.pop();
            s2.push(value);
       }
       int result = s1.pop();
       while(s2.size() != 0){
        int poppedValue = s2.pop();
        s1.push(poppedValue);
       }
       return result;
    }
    
    public int peek() {
        while(s1.size() > 1){
            int value = s1.pop();
            s2.push(value);
       }
       int result = s1.peek();
        while(s2.size() != 0){
            int poppedValue = s2.pop();
            s1.push(poppedValue);
       }
       return result;
    }
    
    public boolean empty() {
        return s1.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */