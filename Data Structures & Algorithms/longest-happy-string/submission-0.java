class Solution {
    class Pair{
        char c;
        int f;
        public Pair(char c, int f){
            this.c = c;
            this.f = f;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
       PriorityQueue<Pair> heap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.f, p1.f));
        if(a > 0)
            heap.add(new Pair('a', a));
        if(b > 0)
            heap.add(new Pair('b', b));
        if(c > 0)
            heap.add(new Pair('c', c));
        StringBuilder sb = new StringBuilder();
        Pair temp = null;
        while(!heap.isEmpty()){
            int len = sb.length();
            if(len >= 2 && sb.charAt(len-1) == heap.peek().c && sb.charAt(len-2) == heap.peek().c){
                //nu putem pune primul caracter;
                temp = heap.poll();
                if(heap.isEmpty()){
                    return sb.toString();
                }
                Pair extracted = heap.poll();
                sb.append(extracted.c);
                int newFreq = extracted.f;
                if(newFreq > 1){
                    heap.add(new Pair(extracted.c, newFreq - 1));
                }
                heap.add(temp);
            }else{
                Pair extracted = heap.poll();
                sb.append(extracted.c);
                int newFreq = extracted.f;
                if(newFreq > 1){
                    heap.add(new Pair(extracted.c, newFreq - 1));
                }

            }
        }
        return sb.toString();
    }
}