class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int currPeople = 0;
        for(int i=0; i<trips.length; i++){
            //1. dam jos pasagerii care trebuia sa coboare
            while(!heap.isEmpty() && heap.peek()[1] <= trips[i][1]){
                int[] curr = heap.poll();
                currPeople -= curr[0];
            }
            //2. adaugam pasagerii noi
            currPeople += trips[i][0];
            //3. verificare
            if(currPeople > capacity){
                return false;
            }
            //4. adaugare propriu-zisa
            heap.add(new int[]{trips[i][0], trips[i][2]});
        }
        return true;
    }
}