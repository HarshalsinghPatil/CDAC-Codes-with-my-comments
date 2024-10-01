public class CustomStack {
    private int maxSize;    // Maximum size of the stack
    private int[] stackArray;  // Array to hold stack elements
    private int top;        // To track the top of the stack

    // Constructor to initialize the stack
    public CustomStack(int size) {
        maxSize = size;              // Set the size of the stack
        stackArray = new int[maxSize];  // Create an array of that size
        top = -1;                    // Initially, the stack is empty (top is -1)
    }

    // Push method: adds an item to the top of the stack
    public void push(int value) {
        if (top < maxSize - 1) {    // Check if there's space in the stack
            stackArray[++top] = value;   // Increment top and add the value
            System.out.println(value + " pushed onto stack.");
        } else {
            System.out.println("Stack is full. Cannot push " + value);
        }
    }

    // Pop method: removes and returns the top item from the stack
    public int pop() {
        if (!isEmpty()) {
            System.out.println(stackArray[top] + " popped from stack.");
            return stackArray[top--];   // Return the top item and decrement the top
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;   // Return a placeholder value (in this case, -1)
        }
    }

    // Peek method: looks at the top item without removing it
    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];    // Return the top item
        } else {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1;
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);  // Stack is empty if top is -1
    }
}


