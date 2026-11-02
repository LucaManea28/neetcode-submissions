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
       PriorityQueue<Interval> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
       for(Interval i: intervals){
            if(!heap.isEmpty() && heap.peek().end <= i.start){
                heap.poll();
            }
            heap.add(i);
       }
       return heap.size();
    }
}
