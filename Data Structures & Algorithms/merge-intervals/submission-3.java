class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        int i = 1;
        int[] reper = intervals[0];
        while(i < intervals.length){
            if(intervals[i][0] > reper[1]){
                result.add(reper);
                reper = intervals[i];
            }else{
                reper[1] = Math.max(reper[1], intervals[i][1]);
            }
            i++;
        }
        result.add(reper);
        int[][] res = new int[result.size()][2];
        for(int k=0; k<result.size(); k++){
            res[k] = result.get(k);
        }
        return res;
    }
}
