package circular_queue;

public class MyCircularQueue {
	
	private int capacity;
	private int size;
	private int[] queue;
	private int head;
	private int tail;
	
	/** Initialise your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.capacity = k;
        this.size = 0;
        this.tail = -1;
        this.head = 0;
    }
    
    public int size() {
    	return this.size;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (! isFull()) {
        	tail = (tail + 1) % capacity;
        	queue[tail] = value;
        	size++;
        	return true;
        }
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (! isEmpty()) {
        	head = (head + 1) % capacity;
        	size--;
        	return true;
        }
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if (isEmpty()) {
    		return -1;
    	}
        return queue[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if (isEmpty()) {
    		return -1;
    	}
        return queue[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size() == this.capacity;
    }

	public static void main(String[] args) {
		MyCircularQueue c = new MyCircularQueue(6);
		c.enQueue(6);
		System.out.println(c.Rear());
		System.out.println(c.Rear());
		System.out.println(c.deQueue());
		System.out.println(c.enQueue(5));
		System.out.println(c.Rear());
		System.out.println(c.deQueue());	
		System.out.println(c.Front());
	}

}
