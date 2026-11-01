class StockSpanner {
    class Pair{
        int value, span;
        public Pair(int v, int s){
            this.value = v;
            this.span = s;
        }
    }
    Deque<Pair> stack;
    public StockSpanner(){
        stack = new ArrayDeque<>();
    }

    public int next(int price){
        int span = 1;
        while(!stack.isEmpty() && stack.peek().value <= price){
            span += stack.pop().span;
        }
        stack.push(new Pair(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */