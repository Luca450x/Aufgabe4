package org.hbrs.se1.ws24.uebung10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LimitedStackTest {
    private LimitedStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new LimitedStack<>(4);
    }

    @Test
    void testPushWithinCapacity() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.size());
    }

    @Test
    void testPushBeyondCapacity() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThrows(IllegalStateException.class, () -> stack.push(5));
    }

    @Test
    void testPopFromStack() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testEmptyStack() {
        assertTrue(stack.isEmpty());
        assertThrows(java.util.EmptyStackException.class, stack::pop);
    }
}
