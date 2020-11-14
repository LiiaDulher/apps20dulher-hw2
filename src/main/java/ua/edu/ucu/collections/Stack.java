package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.EmptyStackException;

public class Stack {

    private ImmutableLinkedList stack;

    public Stack(){
        stack = new ImmutableLinkedList();
    }

    public Object peek(){
        try {
            return stack.getLast();
        } catch (NullPointerException e) {
            throw new EmptyStackException();
        }
    }

    public Object pop(){
        Object element = peek();
        stack = stack.removeLast();
        return element;
    }

    public void push(Object e){
       stack = stack.addLast(e);
    }


}
