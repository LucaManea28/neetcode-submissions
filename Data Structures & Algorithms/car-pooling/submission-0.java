class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        int people = 0;
        for(int[] t: trips){
            while(!queue.isEmpty() && t[1] >= queue.peek()[2]){
                people -= queue.poll()[0];
            }
            people += t[0];
            if(people > capacity){
                return false;
            }
            queue.add(t);
        }
        return true;
    }
}