class StockSpanner {
    class Pair{
        int value, freq;
        Pair(int value, int freq){
            this.value = value;
            this.freq = freq;
        }
    }
    Deque<Pair> stack;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int cnt = 1;
        while(!stack.isEmpty() && stack.peek().value <= price){
            cnt += stack.pop().freq;
        }
        stack.push(new Pair(price, cnt));
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */