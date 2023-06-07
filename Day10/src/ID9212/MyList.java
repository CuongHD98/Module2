package ID9212;

public class MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public Object[] getElements() {
        return elements;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            E[] newElements = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
    }

    public void add(int index, E e) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) elements[i + 1] = elements[i];
        elements[index] = e;
        size++;
    }

    public E remove(int index) {
        checkIndex(index);

        E e = (E) elements[index];

        for (int i = index; i < size - 1; i++)
            elements[i] = elements[i + 1];

        elements[size - 1] = null;

        size--;
        return e;
    }

    public int size() {
        return size;
    }

    public Object clone() {
        Object[] newElements = new Object[size()];
        newElements = getElements();
        return newElements;
    }

    public boolean contains(E e) {
        boolean check = false;
        for (Object o : elements) {
            if (o.equals(e)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }

    public boolean add(E e) {
        return true;

    }

    public void ensureCapacity(int minCapacity) {
        int minExpand = (elements.length != DEFAULT_CAPACITY) ? 0 : DEFAULT_CAPACITY;
        if (minCapacity > minExpand) {

        }
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }



}
