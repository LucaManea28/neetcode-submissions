class MyHashMap {
    List<Integer> keyList;
    List<Integer> valueList;
    public MyHashMap() {
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        int index = keyList.indexOf(key);
        if(index != -1){
            valueList.set(index, value);
        }else{
            keyList.add(key);
            valueList.add(value);
        }
    }
    
    public int get(int key) {
        int index = keyList.indexOf(key);
        if(index != -1)
            return valueList.get(index);
        return -1;
    }
    
    public void remove(int key) {
        int index = keyList.indexOf(key);
        if(index != -1){
            keyList.remove(index);
            valueList.remove(index);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */