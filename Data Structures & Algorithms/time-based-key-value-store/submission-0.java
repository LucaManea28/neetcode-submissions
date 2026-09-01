class TimeMap {
    private class Pair{
        int time;
        String value;
        public Pair(int time, String value){
            this.time = time;
            this.value = value;
        }
    }
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        List<Pair> search = map.get(key);
        int left = 0, right = search.size() - 1;
        String result = "";
        while(left <= right){
            int mid = left + (right - left) / 2;
            int midTime = search.get(mid).time;
            if(midTime == timestamp)
                return search.get(mid).value;
            if(midTime < timestamp){
                result = search.get(mid).value;
                left = mid + 1;
            }else
                right = mid - 1;
        }
        return result;
    }
}
