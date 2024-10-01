class Program {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);  // Create a stack of size 3

        // Push items onto the stack
        stack.push(10);  // Push 10
        stack.push(20);  // Push 20
        stack.push(30);  // Push 30
        stack.push(40);  // Try to push 40 (but stack is full)

        // Peek at the top of the stack
        System.out.println("Top of the stack: " + stack.peek());

        // Pop items from the stack
        stack.pop();  // Pop 30
        stack.pop();  // Pop 20
        stack.pop();  // Pop 10
        stack.pop();  // Try to pop from empty stack
    }
}