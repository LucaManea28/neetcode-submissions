class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, maxWeight = 0;
        for(int w: weights){
            sum += w;
            maxWeight = Math.max(maxWeight, w);
        }
        int result = 0;
        int left = maxWeight, right = sum;
        while(left <= right){
            int shipCapacity = left + (right-left)/2;
            if(possible(weights, days, shipCapacity)){
                result = shipCapacity;
                right = shipCapacity - 1;
            }else{
                left = shipCapacity + 1;
            }
        }
        return result;
    }
    public boolean possible(int[] weights, int days, int shipCapacity){
        int cnt = 1;
        int i = 0;
        int partialSum = 0;
        while(i < weights.length){
            if(partialSum <= shipCapacity - weights[i])
                partialSum += weights[i];
            else{
                cnt++;
                partialSum = weights[i];
            }
            i++;
        }
        return cnt <= days;
    }
}