class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new ArrayDeque<>();
        Queue<Integer> dQueue = new ArrayDeque<>();
        for(int i=0; i<senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                rQueue.add(i);
            }else{
                dQueue.add(i);
            }
        }
        while(!rQueue.isEmpty() && !dQueue.isEmpty()){
            int rTurn = rQueue.poll();
            int dTurn = dQueue.poll();
            if(rTurn < dTurn){
                rQueue.add(rTurn + senate.length());
            }else{
                dQueue.add(dTurn + senate.length());
            }
        }
        if(rQueue.isEmpty()){
            return "Dire";
        }
        return "Radiant";
    }
}