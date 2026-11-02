class Solution {
    PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    public int lastStoneWeight(int[] stones) {
        for(int i: stones){
            heap.add(i);
        }
        while(heap.size() >= 2){
            int x = heap.poll();
            int y = heap.poll();
            if(y < x){
                heap.add(x-y);
            }
        }
        if(heap.isEmpty()){
            return 0;
        }
        return heap.poll();
    }
}
