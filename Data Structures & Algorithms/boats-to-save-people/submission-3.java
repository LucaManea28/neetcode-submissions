class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
       int boats = 0;
       int left = 0, right = people.length - 1;
       while(left <= right){
          if(left == right){
            return boats + 1;
          }
          int totalSum = people[left] + people[right];
          if(totalSum <= limit){
            boats++;
            left++;
            right--;
          }else if(totalSum > limit){
            boats++; //for the rightest person
            right--;
          }
       }
       return boats;
    }
}