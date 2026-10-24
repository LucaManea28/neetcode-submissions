class Solution {
    class Pair{
        char c;
        int freq;
        public Pair(char c, int f){
            this.c = c;
            this.freq = f;
        }
    }
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        for(char c: freq.keySet()){
            heap.add(new Pair(c, freq.get(c)));
        }
        StringBuilder result = new StringBuilder();
        Pair temp = null;
        while(!heap.isEmpty()){
            Pair added = heap.poll();
            result.append(added.c);
            int newFreq = added.freq - 1;
            if(temp != null){
                heap.add(temp);
                temp = null;
            }
            if(newFreq > 0){
                temp = new Pair(added.c, newFreq);
            }
        }
        if(result.length() != s.length())
            return "";
        return result.toString();
    }
}