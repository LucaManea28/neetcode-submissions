class LRUCache {
    class Node{
        int key;
        int value;
        Node prev, next;
        public Node(int k, int v){
            this.key = k;
            this.value = v;
            prev = null;
            next = null;
        }
    }
    Map<Integer, Node> map;
    int capacity;
    Node head, tail;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        addFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addFirst(node);
        }else{
            Node node = new Node(key, value);
            map.put(key, node);
            addFirst(node);

            if(map.size() > capacity){
                Node deleted = tail.prev;
                deleteNode(deleted);
                map.remove(deleted.key);
            }
        }
    }

    public void addFirst(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node; 
    }

    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
