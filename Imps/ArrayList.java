import java.util.Iterator;


public class ArrayList<E> {
    // data members
    private E[] elements;
    private int size;

    // Constructors
    // O(1)
    public ArrayList() {
        this(10);
        // elements = (E[]) new Object[10];
        // size = 0;
    }

    // O(1)
    public ArrayList(int capacity) {
        // elements = new E[capacity]; // will NOT work
        elements = (E[]) new Object[capacity]; // O(1)
        size = 0;
    }

    // Adding an item to the list (2 methods)
    public boolean add(E item) {
        // System.out.println("add(E): Adding item " + item + " at index " + size);
        return add(size, item);
    }

    public boolean add(int index, E item) {
        // System.out.println("add(i,E): Adding item " + item + " at index " + index);
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        ensureCapacity();

        // System.out.println("Starting to shift items right.");
        for (int i = size - 1; i >= index; i--) {
            // System.out.println("Moving item at " + i + " to location " + (i + 1));
            elements[i + 1] = elements[i]; // shift to right
        }

        elements[index] = item;
        size++; // increase count of items
        return true;
    }

    // Removing an object from the list
    /** Removes the first (not all) occurrence of o */
    public boolean remove(Object o) {
        E item = (E) o; // unsafe!
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) { // do NOT use ==
                remove(i);
                return true;
            }
        }
        return false;
    }

    // Removing the item at index from the list
    // O(n) when removing at index 0
    public E remove(int index) {
        checkIndex(index);
        E item = elements[index];
        for (int i = index; i < size - 1; i++)
            elements[i] = elements[i + 1]; // shift items left
        size--; // remember to bookeep
        return item;
    }

    // Grow the list if needed\
    // O(1) if no resize needed.
    // O(n) operations if resize is needed
    private void ensureCapacity() {
        if (size >= elements.length) {
            int newCap = (int) (elements.length * 1.5);
            E[] newElements = (E[]) new Object[newCap];
            for (int i = 0; i < size; i++)
                newElements[i] = elements[i];
            elements = newElements;
        }
    }

    // Check if the index is valid
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(
                    "Index out of bounds. Must be between 0 and " +
                            (size - 1));
    }

    // Getter and Setter
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    /** Sets index to hold item and returns the replaced item (or null if empty) */
    public E set(int index, E item) {
        checkIndex(index);
        E oldItem = elements[index];
        elements[index] = item;
        return oldItem;
    }

    // Size of the list
    public int size() {
        return size;
    }

    // Clear the list
    /**
     * Only sets size to 0, does not allocate a new array or set elements to null
     */
    public void clear() {
        size = 0;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return (size == 0);
    }

    // Shrink the list to size
    public void trimToSize() {
        if (size != elements.length) {
            E[] newElements = (E[]) new Object[size];
            for (int i = 0; i < size; i++)
                newElements[i] = elements[i];
            elements = newElements;
        }
    }

    // toString() method
    
    // O(n) time complexity
    // O(n) space complexity when using String
    // O(1) space complexity when using StringBuilder
    public String toString() {
        if (size == 0)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++)
            sb.append(elements[i]).append(" ");
            // s += elements[1]
        sb.append(elements[size - 1]).append("]");
        return sb.toString();
    }

    // Iterator for the list
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    // Inner class that implements Iterator<E>
    private class ArrayIterator implements Iterator<E> {
        private int current = -1;

        public boolean hasNext() {
            return current < size - 1;
        }

        public E next() {
            return elements[++current]; // current++
        }
    }

    public static void main_test_given(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("\"New York\"");
        cities.add("\"San Diego\"");
        cities.add("Atlanta");
        cities.add("Baltimore");
        cities.add("Pittsburg");
        // display the content of the list
        System.out.println("Using our toString:" + cities.toString());

        // iterator to display the elements of the list
        System.out.println("Using our iterator:");
        Iterator<String> cityIterator = cities.iterator();
        while(cityIterator.hasNext()) {
              System.out.print(cityIterator.next() + " ");
        }
        System.out.println();

        // get(index) to display the elements of the list
        System.out.println("Manual iteration w/ for loop and .size():");
        for(int i=0; i<cities.size(); i++) {
              System.out.print(cities.get(i) + " ");
        }

        cities.add(2, "Bethlehem");
        System.out.println("\nUsing our toString:" + cities.toString());
     }
  
    public static void main_private_test(String[] args) {
        ArrayList<String> myAl = new ArrayList<>();
        myAl.add("testItem");
        System.out.println(myAl.toString());
    }

    public static void main(String[] args){
        // main_private_test(args);
        main_test_given(args);
    }
}
