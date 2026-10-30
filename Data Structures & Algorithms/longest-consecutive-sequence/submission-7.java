class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for(int i: nums){
        set.add(i);
       }
       if(set.isEmpty()){
        return 0;
       }
       int maxLen = 1;
       for(int right = 0; right < nums.length; right++){
          if(!set.contains(nums[right] - 1)){
            //left is the start of a sequence
            int currLen = 1;
            int startElement = nums[right];
            while(set.contains(startElement + 1)){
                currLen++;
                startElement ++;
            }
            //daca nu exista secvneta si faceam Math.max in bucla, atunci ramanea mereu 0
            maxLen = Math.max(maxLen, currLen);
          }
       }
       return maxLen;
    }
}
