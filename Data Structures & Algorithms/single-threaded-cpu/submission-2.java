class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> start = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for(int i=0; i<tasks.length; i++){
            int[] task = tasks[i];
            start.add(new int[]{i, task[0]});
        }
        long globalTimer = 0;
        PriorityQueue<int[]> duration = new PriorityQueue<>((a,b) -> {
            if(a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[0], b[0]);
        });
        int n = tasks.length;
        int[] result = new int[n];
        int i = 0;
        int j = 0;
        while(n > 0){
            if(duration.isEmpty() && !start.isEmpty() && globalTimer < start.peek()[1]){
                globalTimer = start.peek()[1];
            }
            while(!start.isEmpty() && start.peek()[1] <= globalTimer){
                int[] task = start.poll();
                duration.add(new int[]{task[0], tasks[task[0]][1]});
            }
            int[] extractTask = duration.poll();
            globalTimer += extractTask[1];
            result[i++] = extractTask[0];
            n--;
        }
        return result;
    }
}