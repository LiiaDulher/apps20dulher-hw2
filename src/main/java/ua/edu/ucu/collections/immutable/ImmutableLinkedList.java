package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList{

    private final Node first;
    private final int listLength;

    public ImmutableLinkedList(){
        first = null;
        listLength = 0;
    }

    private ImmutableLinkedList(Node base, int size){
        if (base == null){
            first = null;
        } else {
            first = base.clone();
        }
        listLength = size;
    }

    public ImmutableLinkedList(Object[] elements){
        if (elements.length == 0) {
            first = null;
            listLength = 0;
        } else {
            listLength = elements.length;
            first = new Node(elements[0]);
            Node curNode = first;
            for (int i = 1; i < elements.length; i++) {
                Node newNode = new Node(elements[i]);
                curNode.setNext(newNode);
                curNode = curNode.getNext();
            }
        }
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        Object[] elem = {e};
        return addAll(index, elem);
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()){
            return new ImmutableLinkedList(c);
        }
        if (index == 0){
            return new ImmutableLinkedList(c).addAll(toArray());
        }
        Node newNode = first.clone();
        Node curNode = newNode;
        for (int i = 0; i < index - 1; i++){
            curNode = curNode.getNext();
        }
        Node indexNode = curNode.getNext();
        for (int i = 0; i < c.length; i++){
            curNode.setNext(new Node(c[i]));
            curNode = curNode.getNext();
        }
        curNode.setNext(indexNode);
        return new ImmutableLinkedList(newNode, listLength + c.length);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node curNode = first;
        for (int i = 0; i < index; i++){
            curNode = curNode.getNext();
        }
        return curNode.getValue();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = first.clone();
        if (index == 0) {
            newNode = newNode.getNext();
        } else {
            Node curNode = newNode;
            for (int i = 0; i < index - 1; i++) {
                curNode = curNode.getNext();
            }
            curNode.setNext(curNode.getNext().getNext());
        }
        return new ImmutableLinkedList(newNode, listLength - 1);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = first.clone();
        Node curNode = newNode;
        for (int i = 0; i < index; i++){
            curNode = curNode.getNext();
        }
        curNode.setValue(e);
        return new ImmutableLinkedList(newNode, size());
    }

    // TODO REWRITE
    @Override
    public int indexOf(Object e) {
        Node curNode = first;
        for (int i = 0; i < listLength; i++){
            if (e.equals(curNode.getValue())){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return listLength;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Object[] toArray() {
        Object[] linkedListArray = new Object[listLength];
        Node curNode = first;
        for (int i = 0; i < listLength; i++){
            linkedListArray[i] = curNode.getValue();
            curNode = curNode.getNext();
        }
        return linkedListArray;
    }

    @Override
    public String toString() {
        String stringRepresentation = "";
        Object[] arrayList = toArray();
        for (int i = 0; i < size(); i++){
            stringRepresentation += arrayList[i] + " ";
        }
        stringRepresentation += "\n";
        return stringRepresentation;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst(){
        try {
            return get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new NullPointerException();
        }
    }

    public Object getLast() {
        try {
            return get(size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NullPointerException();
        }
    }

    public ImmutableLinkedList removeFirst() {
        try {
            return remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new NullPointerException();
        }
    }

    public ImmutableLinkedList removeLast() {
        try {
            return remove(size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NullPointerException();
        }
    }

}
