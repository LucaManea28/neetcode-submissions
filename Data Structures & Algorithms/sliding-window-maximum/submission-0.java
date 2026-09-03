class Solution {
    public class Pair{
        int value, index;
        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int[] result = new int[nums.length -  k + 1];
        int cnt = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> Integer.compare(b.value, a.value));
        for(int right = 0; right < nums.length; right++){
            queue.add(new Pair(nums[right], right));
            if(right - left + 1 > k){
                left++; 
            }
            while(queue.peek().index < left)
                queue.poll();
            if(right - left + 1 == k){
                result[cnt++] = queue.peek().value;
            }
        }
        return result;
    }
}
