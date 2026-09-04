class MedianFinder {
    PriorityQueue<Integer> left; 
    PriorityQueue<Integer> right; 
    public MedianFinder() {
        left = new PriorityQueue<>((a,b) -> Integer.compare(b,a)); //max heap
        right = new PriorityQueue<>(); //min heap 
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || num <= left.peek())
            left.add(num);
        else
            right.add(num);
        //reechilibrare
        if(left.size() > right.size() + 1)
            right.add(left.poll());
        else if(right.size() > left.size()){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        int totalSize = left.size() + right.size();
        if(totalSize % 2 == 0){
            return (double)(left.peek() + right.peek())/2;
        }else
            return (double)left.peek();
    }
}
