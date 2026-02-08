import java.util.Stack;

class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    public void push(int x) {
        stackIn.push(x);
    }
    public int pop() {
        moveIfNeeded();
        return stackOut.pop();
    }
    public int peek() {
        moveIfNeeded();
        return stackOut.peek();
    }
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
    private void moveIfNeeded() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}
