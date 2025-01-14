package org.hbrs.se1.ws24.uebung10;

import java.util.Stack;

public class LimitedStack<T> extends Stack<T> {
    private final int maxCapacity;

    public LimitedStack(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be greater than 0");
        }
        this.maxCapacity = maxCapacity;
    }

    @Override
    public T push(T item) {
        if (this.size() >= maxCapacity) {
            throw new IllegalStateException("Stack is full");
        }
        return super.push(item);
    }
}
