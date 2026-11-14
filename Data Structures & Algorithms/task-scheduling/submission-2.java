class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks){
            freq[c-'A']++;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for(int i: freq){
            if(i > 0){
                heap.add(i);
            }
        }
        int globalTime = 0;
        List<Integer> remained = new ArrayList<>();
        while(!heap.isEmpty()){
            int cycle = n+1;
            remained.clear();
            while(cycle > 0 && !heap.isEmpty()){
                int popped = heap.poll();
                remained.add(popped-1);
                globalTime++;
                cycle--;
            }
            for(int i: remained){
                if(i > 0){
                    heap.add(i);
                }
            }
            if(!heap.isEmpty()){
                globalTime += cycle;
            }

        }
        return globalTime;
    }
}
