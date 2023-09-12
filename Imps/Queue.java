public class Queue<E> {
    private LinkedList<E> list;

    // O(1)
    public Queue() {
        list = new LinkedList<>();
    }

    // O(1)
    public void offer(E item) {
        list.addLast(item);
    }

    // O(1)
    public E poll() {
        E value = list.getFirst(); // O(1)
        list.removeFirst();  // O(1)
        return value;
    }

    // O(1)
    public E peek() {
        return list.getFirst();
    }

    // O(n)
    public String toString() {
        return "Queue: " + list.toString();
    }

    // O(1)
    public int size() {
        return list.size();
    }

    // O(1)
    public void clear() {
        list.clear();
    }

    // O(1)
    public boolean isEmpty() {
        return list.size() == 0;
    }

    public static void main(String[] args) {
        Queue<String> cityQueue = new Queue<>(); // FIFO
        cityQueue.offer("\"New York\"");
        cityQueue.offer("\"San Diego\"");
        cityQueue.offer("Atlanta");
        cityQueue.offer("Baltimore");
        cityQueue.offer("Pittsburg");
        System.out.println("City Queue (toString): " + 
                              cityQueue.toString());
        System.out.print("City Queue (poll): ");
        while(!cityQueue.isEmpty())
            System.out.print(cityQueue.poll() + " ");
    }
}
