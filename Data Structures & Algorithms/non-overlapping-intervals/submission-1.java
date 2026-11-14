class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[] reper = intervals[0];
        int cnt = 0;
        int i = 1;
        while(i < intervals.length){
            if(intervals[i][0] >= reper[1]){
                reper = intervals[i];
            }else{
                cnt++;
                if(intervals[i][1] < reper[1]){
                    reper = intervals[i]; 
                }
            }
            i++;
        }
        return cnt;
    }
}
