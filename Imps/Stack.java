import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {
    private ArrayList<E> elements;

    /** No arg initializes the backing arraylist variable */
    public Stack() {
        elements = new ArrayList<>();
        // E myNewE = new E(); // will NOT compile
    }

    /**
     * One arg initializes the backing arraylist variable to be able to hold given
     * size
     */
    public Stack(int capacity) {
        elements = new ArrayList<>(capacity);
        // E myNewE = new E(); // will NOT compile
    }

    /** Add the given element to 'top' of the stack */
    public void push(E item) {
        elements.add(item);
    }

    /**
     * Removes the item from the top of the stack, if present
     * 
     * @return null if empty, otherwise the top of the stack
     */
    public E pop() {
        if (isEmpty())
            // return null;
            throw new EmptyStackException();
        // return elements.remove( elements.size()-1 );
        E value = peek();
        elements.remove(elements.size() - 1);
        return value;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the
     * stack.
     * 
     * @return null if empty, the topmost element otherwise
     */
    public E peek() {
        if (isEmpty())
            // return null;
            throw new EmptyStackException();
        return elements.get(elements.size() - 1);
    }

    /**
     * Tests if this stack is empty.
     * 
     * @return true if and only if this stack contains no items; false otherwise.
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /** Returns the number of items in this stack */
    public int size() {
        return elements.size();
    }

    /**
     * Use the built-in toString of ArrayList to represent the contents of this
     * stack
     */
    @Override
    public String toString() {
        return elements.toString();
    }

    boolean nonStaticBool = false;
    static boolean bHello = true;
    // static E myStaticE; // will NOT compile

    // public static void helloWorld(E theE){ // will NOT compile
    public static void helloWorld() {
        System.out.println("Hello World!");
    }

    public static void main_lecture_test(String[] args) {
        Stack.helloWorld();
        Stack.bHello = false;

        Stack<Integer> stackInts = new Stack<>();
        stackInts.push(1);

        Stack<String> s = new Stack<>(); // make an instance of the class Stack
        System.out.println("Size of stack: " + s.size());
        System.out.println("Stack is empty? " + s.isEmpty());
        // s.push( 3.14 ); // autoboxing makes this a Double
        s.push("CSE017");
        s.push("Summer");
        s.push("Session 1");

        System.out.println("Size of stack: " + s.size());
        System.out.println("Stack is empty? " + s.isEmpty());

        System.out.println("The stack (rhs is top): " + s);
        System.out.println("Peek at top of list: " + s.peek());
        System.out.println("The stack (rhs is top): " + s);

        String pop1 = s.pop();
        String pop2 = s.pop();
        System.out.println("Pop1: " + pop1);
        System.out.println("Pop2: " + pop2);

        System.out.println("The stack (rhs is top): " + s);
    }

    public static void main(String[] args) {
        Stack<String> cityStack = new Stack<>();
        cityStack.push("\"New York\"");
        cityStack.push("\"San Diego\"");
        cityStack.push("Atlanta");
        cityStack.push("Baltimore");
        cityStack.push("Pittsburg");
        System.out.println("City Stack (toString): " +
                cityStack.toString());
        System.out.print("City Stack (pop): ");
        while (!cityStack.isEmpty())
            System.out.print(cityStack.pop() + " ");
    }

}
