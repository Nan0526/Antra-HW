package DayTwoDataStructure;

class Stack
{
    private int arr[];
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    Stack(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Utility function to add an element `x` to the stack
    public void push(int x)
    {
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    // Utility function to pop a top element from the stack
    public int pop()
    {
        // check for stack underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        System.out.println("Removing " + peek());

        // decrease stack size by 1 and (optionally) return the popped element
        return arr[top--];
    }

    // Utility function to return the top element of the stack
    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }

        return -1;
    }

    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }

    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == -1;               // or return size() == 0;
    }

    // Utility function to check if the stack is full or not
    public boolean isFull() {
        return top == capacity - 1;     // or return size() == capacity;
    }
}

class Main
{
    public static void main (String[] args)
    {
        Stack stack = new Stack(3);

        stack.push(1);      // inserting 1 in the stack
        stack.push(2);      // inserting 2 in the stack

        stack.pop();        // removing the top element (2)
        stack.pop();        // removing the top element (1)

        stack.push(3);      // inserting 3 in the stack

        System.out.println("The top element is " + stack.peek());
        System.out.println("The stack size is " + stack.size());

        stack.pop();        // removing the top element (3)

        // check if the stack is empty
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}


/*
//using java collections
import java.util.Stack;

class Main
{
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();

        stack.push("A");    // Insert `A` into the stack
        stack.push("B");    // Insert `B` into the stack
        stack.push("C");    // Insert `C` into the stack
        stack.push("D");    // Insert `D` into the stack

        // prints the top of the stack (`D`)
        System.out.println("The top element is " + stack.peek());

        stack.pop();        // removing the top element (`D`)
        stack.pop();        // removing the next top (`C)

        // returns the total number of elements present in the stack
        System.out.println("The stack size is " + stack.size());

        // check if the stack is empty
        if (stack.empty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}
 */