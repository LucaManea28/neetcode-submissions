class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i])/speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(stack.isEmpty() || cars[i][1] > stack.peek())
                //formeaza o noua flota si o punem in stiva
                //daca are nevoie de mai mult timp ca sa prinda masina din fata
                stack.push(cars[i][1]);
        }
        return stack.size();
    }
}
