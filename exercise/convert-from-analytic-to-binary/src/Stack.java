import java.util.Arrays;

public class Stack<T> {
    private int size;
    private int top;

    private T[] array;

    public boolean isEmpty() {
        return (top < 0);
    }

    public Stack(int size) {
        top = -1;
        this.size = size;
        array = (T[]) new Object[size];
    }

    public boolean push(T data) {
        if (top >= size) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            array[++top] = data;
            return true;
        }
    }

    public T pop() {
        if (top < 0)
        {
            System.out.println("Stack Underflow");
            return (T) array;
        }
        else
        {
            return array[top--];
        }
    }

    public T[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < array.length; i++) {
            text += array[i] + " ";
        }
        return text;
    }
}