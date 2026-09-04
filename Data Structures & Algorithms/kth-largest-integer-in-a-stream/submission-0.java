class KthLargest {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i: nums){
            heap.add(i);
        }
    }
    
    public int add(int val) {
        heap.add(val);
        while(heap.size() > k)
                heap.poll();
        return heap.peek();
    }
}
