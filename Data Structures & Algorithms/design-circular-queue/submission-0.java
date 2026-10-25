class MyCircularQueue {
    int capacity;
    int front, rear, size;
    int[] queue;
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        this.front = 0;
        this.rear = 0;
        this.queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(size == capacity){
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        //nu e nevoie sa sterg valoarea din array, se va suprascrie la enque
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if(size == 0){
            return -1;
        }
        return queue[front];
    }
    
    public int Rear() {
        if(size == 0){
            return -1;
        }
        return queue[(rear - 1 + capacity) % capacity]; //evit index negativ cand rear = 0
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */