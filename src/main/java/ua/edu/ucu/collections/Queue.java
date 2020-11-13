package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue(){
        queue = new ImmutableLinkedList();
    }

    public Object peek() {
        try {
            return queue.getFirst();
        } catch (IndexOutOfBoundsException e) {
            throw new NullPointerException();
        }
    }

    public Object dequeue() {
        Object element = peek();
        queue = queue.removeFirst();
        return element;
    }

    public void enqueue(Object e){
        queue = queue.addLast(e);
    }

}
