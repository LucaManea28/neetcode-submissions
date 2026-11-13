class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //the max number of solutions would be 2
        //if we have 3 el => 3 * (n/3) => the result would be grater than n, which is the total number of elements so is not possible
        int c1 = 0, c2 = 0, s1 = 0, s2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == c1){
                s1++;
            }else if(nums[i] == c2){
                s2++;
            }else if(s1 == 0){
                c1 = nums[i];
                s1 = 1;
            }else if(s2 == 0){
                c2 = nums[i];
                s2 = 1;
            }else{
                s1--;
                s2--;
            }
        }
        s1 = 0;
        s2 = 0;
        for(int num: nums){
            if(num == c1){
                s1++;
            }else if(num == c2){
                s2++;
            }
        }
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if(s1 > len/3){
            res.add(c1);
        }
        if(s2 > len/3){
            res.add(c2);
        }
        return res;
    }
}