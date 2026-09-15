class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0;
        int score1 = 0, score2 = 0;
        for(int i: nums){
            if(i == c1)
                score1++;
            else if(i == c2)
                score2++;
            else if(score1 == 0){
                c1 = i;
                score1 = 1;
            }else if(score2 == 0){
                c2 = i;
                score2 = 1;
            }else{
                score1--;
                score2--;
            }
        }
        score1 = 0;
        score2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == c1)
                score1++;
            if(nums[i] == c2)
                score2++;
        }
        List<Integer> list = new ArrayList<>();
        if(score1 > nums.length/3)
            list.add(c1);
        if(score2 > nums.length/3)
            list.add(c2);
        return list;
    }
}