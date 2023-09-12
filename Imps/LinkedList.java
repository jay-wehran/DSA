import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> {
    // Data members
    private Node head, tail;
    int size;

    // Inner class Node
    private class Node {
        E value;
        Node next;

        Node(E initialValue) {
            value = initialValue;
            next = null;
        }
    }

    // Constructor
    // O(1)
    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    // Adding an item to the list
    // O(1)
    public boolean addFirst(E item) {
        Node newNode = new Node(item);
        if (head == null) { // this is the first and only node!
            head = tail = newNode;
        } else { // the list is not empty
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }

    // O(1)
    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if (head == null) { // the list is empty
            head = tail = newNode;
        } else { // the list is not empty
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    // O(1)
    public boolean add(E item) {
        return addFirst(item);
    }

    // Retrieving an item from the list
    // O(1)
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }

    // O(1)
    public E getLast() {
        if (head == null)
            throw new NoSuchElementException();
        return tail.value;
    }

    // Removing an item from the list
    // O(1)
    public boolean removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        head = head.next;
        if (head == null) // was last item in list
            tail = null;
        size--;
        return true;
    }

    // O(n)
    public boolean removeLast() {
        if (head == null)
            throw new NoSuchElementException();
        if (size == 1)
            return removeFirst();
        // 2 or more elements
        Node current = head;
        Node previous = null;
        while (current.next != null) { // go until the end of the list
            previous = current;
            current = current.next;
        }
        // at this piont, previous refers to the 2nd to last element
        previous.next = null;
        tail = previous;
        size--;
        return true;
    }

    // toString() method
    // O(n) in both time and space
    public String toString() {
        String output = "[";
        Node node = head;
        while (node != null) {
            output += node.value + " ";
            node = node.next;
        }
        output += "]";
        return output;
    }

    // clear, check if empty, and size of the list
    // O(1)
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // O(1)
    public boolean isEmpty() {
        return (size == 0);
    }

    // O(1)
    public int size() {
        return size;
    }

    // Implementing an iterator for the list
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node current = head;

        public boolean hasNext() {
            return (current != null);
        }

        public E next() {
            if (current == null)
                throw new NoSuchElementException();
            E value = current.value;
            current = current.next;
            return value;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> cityList = new LinkedList<>();
        cityList.addFirst("Boston");
        cityList.addFirst("Philadelphia");
        cityList.addFirst("\"San Francisco\"");
        cityList.addFirst("Washington");
        cityList.addFirst("Portland");
  
        System.out.println(cityList.toString());
  
        Iterator<String> llIterator = cityList.iterator();
        System.out.print("LinkedList (iterator): ");
        while(llIterator.hasNext()) {
           System.out.print(llIterator.next() + " ");
        }
     }
  
}
