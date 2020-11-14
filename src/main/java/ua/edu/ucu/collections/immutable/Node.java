package ua.edu.ucu.collections.immutable;

public class Node {
    private Object value;
    private Node next = null;

    public Node(Object e) {
        value = e;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node clone() {
        Node startNode = new Node(value);
        Node curNode = this;
        Node newNode = startNode;
        while (curNode.next != null) {
            curNode = curNode.getNext();
            newNode.setNext(new Node(curNode.getValue()));
            newNode = newNode.getNext();
        }
        return startNode;
    }
}
