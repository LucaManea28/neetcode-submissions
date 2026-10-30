class TimeMap {
    class Obj{
        String value;
        int time;
        public Obj(String v, int t){
            this.value = v;
            this.time = t;
        }
    }
    Map<String, List<Obj>> map;
    public TimeMap() {
       map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
       }
       map.get(key).add(new Obj(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
       String value = "";
       if(!map.containsKey(key)){
            return "";
       }else{
            List<Obj> timeList = map.get(key);
            int left = 0, right = timeList.size() - 1;
            while(left <= right){
                int mid = left + (right-left)/2;
                if(timeList.get(mid).time <= timestamp){
                    value = timeList.get(mid).value;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
       }
       return value;
    }
}
