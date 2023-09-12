import java.util.Comparator;

public class PriorityQueue<E> {
    private ArrayList<E> list;
    private Comparator<E> comparator;

    /** No-arg constructor sets comparator to null; uses the compareTo of type E (i.e. E should be (Comparable<E>) */
    public PriorityQueue() {
        list = new ArrayList<>();
        comparator = null;
    }

    public PriorityQueue(Comparator<E> c) {
        list = new ArrayList<>();
        comparator = c;
    }

    public E poll() {
        E value = list.get(0);
        list.remove(0);
        return value;
    }

    /** the heart of this data structure; inserts item based on priority as judged by comparitor */
    public void offer(E item) {
        int i, c;
        for (i = 0; i < list.size(); i++) { // determine where to insert item, based on priority (comparitor)
            if (comparator == null)
                c = ((Comparable<E>) item).compareTo(list.get(i));
            else // use the 1-arg constructor provided comparator
                c = comparator.compare(item, list.get(i));
            if (c < 0)
                break;
        }
        list.add(i, item);
    }

    public E peek() {
        return list.get(0);
    }

    public String toString() {
        return "Priority Queue: " + list.toString();
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public static void main(String[] args) {
        // PriorityQueue<String> cityPriorityQueue = new PriorityQueue<>();

        Comparator<String> c = new StringLenComparator();

        PriorityQueue<String> cityPriorityQueue = new PriorityQueue<>( c );

        // cityPriorityQueue.offer("\"New York\"");
        // cityPriorityQueue.offer("\"San Diego\"");
        cityPriorityQueue.offer("New_York");
        cityPriorityQueue.offer("San_Diego");
        cityPriorityQueue.offer("Atlanta");
        cityPriorityQueue.offer("Baltimore");
        cityPriorityQueue.offer("Pittsburg");
        cityPriorityQueue.offer("z");
        cityPriorityQueue.offer("zzz");
        cityPriorityQueue.offer("12345678901234567890");
        System.out.println("\nCity Priority Queue: " +
                cityPriorityQueue.toString());
        System.out.print("City Priority Queue (poll): ");
        while (!cityPriorityQueue.isEmpty()) {
            System.out.print(cityPriorityQueue.poll() + " ");
        }

    }
}

class StringLenComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'compare'");
        // return Integer.compare(o1.length(), o2.length());
        return Integer.compare(o2.length(), o1.length());
    }
    
}
