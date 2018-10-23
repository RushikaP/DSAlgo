package com.mars;

public class Stack {
    public static final int DEFAULT_SIZE = 100;

    private int[] array;
    private int top;

    public Stack(int maxSize) {
        array = new int[maxSize];
        top = -1;
    }

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Trying to access element of empty stack");
        }
        return array[top];
    }

    public int pop() throws StackEmptyException {
        int elem = peek();
        top--;
        return elem;
    }

    public void push(int elem) throws StackOverflowException {
        if (top == array.length - 1)
            throw new StackOverflowException(String.format("Trying to push %d to an already full stack", elem));
        array[++top] = elem;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        try {
            for (int i = 0; i < 10; i++) {
                s.push(i);
            }
        } catch (StackOverflowException e) {
            System.out.println("Stack Full, cannot push more. Ignoring inputs");
        }
        while (!s.isEmpty()) {
            try {
                System.out.println(s.pop());
            } catch (StackEmptyException ignored) {
            }
        }
    }
}

class StackEmptyException extends Exception {

    public StackEmptyException(String s) {
        super(s);
    }
}

class StackOverflowException extends Exception {
    public StackOverflowException(String s) {
        super(s);
    }
}
