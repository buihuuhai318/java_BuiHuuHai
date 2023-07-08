import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;

    public MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = elements.length + 1;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void addByIndex(int index, E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        for (int i = elements.length - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        size++;
        elements[index] = element;
    }

    public E remove(int index) {
        E newElements = elements[index];
        for (int i = index + 1; i < elements.length; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        elements = Arrays.copyOf(elements, elements.length);
        return newElements;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return elements[index];
    }

    public String show() {
        String string = "";
        for (int i = 0; i < elements.length; i++) {
            string += "phần tử thứ " + i + ": " + elements[i] + "\n";
        }
        return string;
    }

    @Override
    public Object clone() {
        MyList<E> clone = new MyList<>(elements.length);
        for (E o : elements) {
            clone.add(o);
        }
        return clone;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (o == elements[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E o) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = o;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        int elementNull = elements.length - size;
        if (elementNull < minCapacity) {
            elements = Arrays.copyOf(elements, elements.length + minCapacity - elementNull);
        } else {
            System.out.println("Capacity was ensure!");
        }

    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int getSize() {
        return size;
    }
}
