class Solution {
    public int[] getOrder(int[][] tasks) {
        //start -> index + startTime
        //duration -> index + durationTime
        PriorityQueue<int[]> start = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for(int i=0; i<tasks.length; i++){
            start.add(new int[]{i, tasks[i][0]});
        }
        PriorityQueue<int[]> duration = new PriorityQueue<>((a,b) ->{
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            }else{
                return Integer.compare(a[0], b[0]);
            }
        });
        int n = tasks.length;
        int[] result = new int[n];
        int i = 0, j = 0;
        long globalTimer = 0;
        while(n > 0){
            if(duration.isEmpty() && !start.isEmpty() && globalTimer < start.peek()[1]){
                globalTimer = start.peek()[1];
            }
            while(!start.isEmpty() && globalTimer  >= start.peek()[1]){
                int[] task = start.poll();
                duration.add(new int[]{task[0], tasks[task[0]][1]});
            }
            int[] extracted = duration.poll();
            globalTimer += extracted[1];
            result[i++] = extracted[0];
            n--;
        }
        return result;
    }
}