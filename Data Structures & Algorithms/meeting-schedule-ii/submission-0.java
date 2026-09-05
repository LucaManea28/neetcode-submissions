/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    //ne cere practic sa gasim nr. maxim de sedinte care pot sa aiba loc in ac. timp
    //asa aflam cata sali avem nevoie
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty())
            return 0;
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(intervals.get(0).end);
        for(int i=1; i<intervals.size(); i++){
            if(!heap.isEmpty() && intervals.get(i).start >= heap.peek())
                heap.poll();
            heap.add(intervals.get(i).end);
        }
        return heap.size();
    }
}
