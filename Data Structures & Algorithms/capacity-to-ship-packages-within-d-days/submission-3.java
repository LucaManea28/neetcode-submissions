class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //range would be from 0 to sum(weights)
        int sum = 0;
        int max = weights[0];
        int leastCapacity = 0;
        for(int i: weights){
            sum += i;
            if(i > max){
                max = i;
            }
        }
        int left = max, right = sum;
        while(left <= right){
            int shipCapacity = left + (right - left)/2;
            if(isPossible(weights, days, shipCapacity)){
                leastCapacity = shipCapacity;
                right = shipCapacity - 1;
            }else{
                left = shipCapacity + 1;
            }
        }
        return leastCapacity;
    }
    private boolean isPossible(int[] weights, int days, int shipCapacity){
        int cntDays = 1;
        int currSum = 0;
        for(int i: weights){
            if(shipCapacity < currSum + i){
                cntDays++;
                currSum = i;
            }else{
                currSum += i;
            }
        }
        return cntDays <= days;
    }
    
}