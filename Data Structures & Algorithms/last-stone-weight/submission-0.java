class Solution {
    PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    public int lastStoneWeight(int[] stones) {
        for(int i: stones)
            queue.add(i);
        while(queue.size() > 1){
            int x = queue.poll();
            int y = queue.poll();
            if(x == y)
                continue;
            else if(y < x){
                queue.add(x - y);
            }
        }
        if(queue.isEmpty())
            return 0;
        return queue.peek();
    }
}
