package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList{

    private final Node first;

    public ImmutableLinkedList(){
        first = null;
    }

    public ImmutableLinkedList(Node base){
        first = base.clone();
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
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
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
        return null;
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
        return get(0);
    }

    public Object getLast() {
        return get(size() - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size() - 1);
    }

}
