class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MIN_VALUE;
        for(int i: piles)
            if(i > high)
                high = i;
        while(low < high){
            int midSpeed = low + (high - low)/2;
            int totalHoursNeeded = 0;
            for(int i: piles){
                totalHoursNeeded += (i + midSpeed - 1)/midSpeed; //pt ceil
            }
            if(totalHoursNeeded <= h){
                high = midSpeed;
            }else{
                low = midSpeed + 1;
            }
        }
        return low; //low si high vor fi egale cu midSpeed
    }
}
