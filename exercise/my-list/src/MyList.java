import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 0;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
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

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public E remove(int index) {
        E element = (E) elements[index];
        for (int i = index + 1; i < elements.length; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        elements = Arrays.copyOf(elements, elements.length - 1);
        return element;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) elements[index];
    }

    public String show() {
        String string = "";
        for (int i = 0; i < elements.length; i++) {
            string += "phần tử thứ " + i + ": " + elements[i] + "\n";
        }
        return string;
    }

    public int getSize() {
        return size;
    }

    public E clone() {
        return (E) Arrays.copyOf(elements, elements.length);
    }
}
