class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks){
            freq[c - 'A']++;
        }
         PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int f: freq){
            if(f > 0){
                heap.add(f);
            }
        }
        int time = 0;
        while(!heap.isEmpty()){
            List<Integer> waitList = new ArrayList<>();
            int cycle = n + 1;
            while(cycle > 0 && !heap.isEmpty()){
                int currFreq = heap.poll();
                if(currFreq > 1){
                    waitList.add(currFreq - 1);
                }
                time++;
                cycle--;
            }
            for(int f: waitList){
                heap.add(f);
            }
            //daca heap nu e gol, inseamna ca ar tr sa mai adug IDLE
            if(!heap.isEmpty()){
                time += cycle;
            }

        }
        return time;
    }
}
