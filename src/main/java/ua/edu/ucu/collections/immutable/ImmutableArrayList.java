package ua.edu.ucu.collections.immutable;

public final class ImmutableArrayList implements ImmutableList{

    private final Object[] listElements;

    public ImmutableArrayList() {
        listElements = new Object[0];
    }

    public ImmutableArrayList(Object[] elements) {
        listElements = elements.clone();
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        Object[] elem = {e};
        return addAll(index, elem);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] elements = new Object[size()+c.length];
        for (int i = 0; i < index; i++) {
            elements[i] = listElements[i];
        }
        for (int i = 0; i < c.length; i++) {
            elements[i + index] = c[i];
        }
        for (int i = index + c.length; i < elements.length; i++) {
            elements[i] = listElements[i - c.length];
        }
        return new ImmutableArrayList(elements);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        return listElements[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Object[] elements = new Object[size() - 1];
        for (int i = 0; i < index; i++) {
            elements[i] = listElements[i];
        }
        for (int i = index; i < elements.length; i++) {
            elements[i] = listElements[i + 1];
        }
        return new ImmutableArrayList(elements);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Object[] elements = toArray();
        elements[index] = e;
        return new ImmutableArrayList(elements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (e.equals(listElements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return listElements.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        return listElements.clone();
    }

    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < size(); i++) {
            bf.append(listElements[i]);
            bf.append(" ");
        }
        bf.append("\n");
        return bf.toString();
    }
}
