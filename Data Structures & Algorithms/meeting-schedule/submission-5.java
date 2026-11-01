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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() < 2){
            return true;
        }
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        Interval reper = new Interval(intervals.get(0).start, intervals.get(0).end);
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start < reper.end){
                return false;
            }
            reper = intervals.get(i);
        }
        return true;
    }
}
