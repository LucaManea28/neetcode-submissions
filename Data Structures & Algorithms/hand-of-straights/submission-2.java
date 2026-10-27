class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int h: hand){
            if(map.containsKey(h)){
                map.put(h, map.get(h) + 1);
            }else{
                map.put(h, 1);
            }
        }
        Arrays.sort(hand);
        for(int i=0; i<hand.length; i++){
            if(map.get(hand[i]) == 0){
                continue;
            }
            for(int j=hand[i]; j<=hand[i] + groupSize - 1; j++){
                if(!map.containsKey(j) || map.get(j) == 0){
                    return false;
                }
                map.put(j, map.get(j) - 1);
            }
        }
        return true;
    }
}
