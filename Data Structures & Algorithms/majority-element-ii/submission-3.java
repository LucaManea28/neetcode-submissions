class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //the max number of solutions would be 2
        //if we have 3 el => 3 * (n/3) => the result would be grater than n, which is the total number of elements so is not possible
        int c1 = 0, c2 = 0;
        int s1 = 0, s2 = 0;
        for(int i : nums){
            //this if - else if structures guarantees that an any point c1 != c2
            if(i == c1){
                s1++;
            }else if(i == c2){
                s2++;
            }else if(s1 == 0){
                c1 = i;
                s1 = 1;
            }else if(s2 == 0){
                c2 = i;
                s2 = 1;
            }else{
                s1--;
                s2--;
            }
        }
        s1 = 0;
        s2 = 0;
        for(int i: nums){
            if(i == c1){
                s1++;
            }
            if(i == c2){
                s2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(s1 > nums.length/3)
            res.add(c1);
        if(s2 > nums.length/3)
            res.add(c2);
        return res;
    }
}