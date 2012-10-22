package za.co.cascott.rpncalculator;

import java.util.Stack;

/*
 * This is the base of the tiny RPN.
 * This is a basic rpn for users.
 */
public class RPN {

    private Stack<Double> stack;

    public RPN() {
        stack = new Stack<Double>();
    }

    public void enter(Double value) {
        stack.push(value);
    }

    /* Takes two values off the stack and pushes another value onto the stack. */
    public void multiply() {
        Double v1 = stack.pop();
        Double v2 = stack.pop();
        stack.push(v1 * v2);
    }

    public void add() {
        Double v1 = stack.pop();
        Double v2 = stack.pop();
        stack.push(v1 + v2);
    }

    public void minus() {
        Double v1 = stack.pop();
        Double v2 = stack.pop();
        stack.push(v1 - v2);
    }

    public void devided() {
        Double v1 = stack.pop();
        Double v2 = stack.pop();
        stack.push(v1 / v2);
    }

    public void clear() {
        stack.clear();
    }

    public Double get() {
        return stack.pop();
    }

}
