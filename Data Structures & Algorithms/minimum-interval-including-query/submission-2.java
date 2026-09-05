class Solution {
    class Pair{
        int end, length;
        public Pair(int end, int length){
            this.end = end;
            this.length = length;
        }
    }
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.length, b.length));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i; // indexul original
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[queries.length];
        int j = 0;
        for(int i=0; i<sortedQueries.length; i++){
            int queryVal = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            while(j < intervals.length && intervals[j][0] <= queryVal){
                heap.add(new Pair(intervals[j][1], intervals[j][1] - intervals[j][0] + 1));
                j++;
            }
            while(!heap.isEmpty() && heap.peek().end < queryVal)
                heap.poll();
            if(!heap.isEmpty())
                result[originalIndex] = heap.peek().length;
            else
                result[originalIndex] = -1;
        }
        return result;
    }
}
