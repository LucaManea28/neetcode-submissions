class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //the result should be between 1 and maxValue of bananas of a day
        int maxBananas = 0;
        for(int i: piles){
            if(i > maxBananas){
                maxBananas = i;
            }
        }
        int left = 1, right = maxBananas;
        int result = 0;
        while(left <= right){
            int midSpeed = left + (right - left)/2;
            if(possible(piles, h, midSpeed)){
                result = midSpeed;
                right = midSpeed - 1;
            }else{
                left = midSpeed + 1;
            }
        }
        return result;
    }
    private boolean possible(int[] piles, int h, int speed){
        int cnt = 0;
        for(int i: piles){
            if(i <= speed){
                cnt++;
            }else{
                cnt += Math.ceil((double) i / speed);
            }
        }
        return cnt <= h;
    }
}
