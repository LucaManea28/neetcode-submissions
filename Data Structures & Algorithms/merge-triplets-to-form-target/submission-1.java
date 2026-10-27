class Solution{
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean first = false, second = false, third = false;
        for(int i=0; i<triplets.length; i++){
            int a = triplets[i][0];
            int b = triplets[i][1];
            int c = triplets[i][2];
            if(a > target[0] || b > target[1] || c > target[2]){
                continue;
            }
            if(a == target[0]){
                first = true;
            }
            if(b == target[1]){
                second = true;
            }
            if(c == target[2]){
                third = true;
            }
            if(first && second && third){
                return true;
            }
        }
        return false;
    }
}
