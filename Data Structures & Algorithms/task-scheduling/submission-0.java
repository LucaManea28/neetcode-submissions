class Solution {
    class Pair{
        int freq, time;
        public Pair(int freq, int time){
            this.freq = freq;
            this.time = time;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        Map<Character, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        for(char c: tasks){
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        for(int value: map.values()){
            heap.add(value);
        }
        int time = 0;
        while(!heap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!heap.isEmpty()){
                int currentMaxFreq = heap.poll();
                currentMaxFreq--;
                if(currentMaxFreq > 0){
                    queue.add(new Pair(currentMaxFreq, time + n));
                }
            }
            if(!queue.isEmpty() && queue.peek().time == time){
                heap.add(queue.poll().freq);
            }
        }
        return time;
    }
}
