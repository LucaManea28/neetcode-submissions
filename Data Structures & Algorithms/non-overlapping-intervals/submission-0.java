class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1)
            return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[] current = intervals[0];
        int cnt = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= current[1]){
                    current = intervals[i];
            }else{
                cnt++;
                //stergem 
                current[1] = Math.min(current[1], intervals[i][1]);
            }
        }
        return cnt;
    }
}
