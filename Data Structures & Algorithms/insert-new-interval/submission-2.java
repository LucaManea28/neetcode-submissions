class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        boolean added = false;
        while(i < intervals.length){
            if(intervals[i][1] < newInterval[0]){
                res.add(intervals[i]);
                i++;
            }else{
                while(i < intervals.length && intervals[i][0] <= newInterval[1]){
                    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                    i++;
                }
                added = true;
                res.add(newInterval);
                break;
            } 
        }
        if(!added){
            res.add(newInterval);
        }
        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        int[][] result = new int[res.size()][2];
        for(int k=0; k<res.size(); k++){
            result[k] = res.get(k);
        }
        return result;
    }
}
