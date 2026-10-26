class TimeMap {
    class Obj{
        String value;
        int timestamp;
        public Obj(String v, int t){
            this.value = v;
            this.timestamp = t;
        }
    }
    Map<String, List<Obj>> map;
    public TimeMap() {
       map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Obj newObj = new Obj(value, timestamp);
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(newObj);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Obj> keyList = map.get(key);
        String result = "";
        int left = 0, right = keyList.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(keyList.get(mid).timestamp <= timestamp){
                result = keyList.get(mid).value;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }
}
