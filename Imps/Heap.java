public class Heap<E extends Comparable<E>> {
    private ArrayList<E> list;

    public Heap() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public String toString() {
        return list.toString();
    }

    public boolean contains(E value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value))
                return true;
        }
        return false;
    }

    public void add(E value) {
        list.add(value); // append value to the heap; maintain shape property
        int currentIndex = list.size() - 1;
        // index of the last element
        while (currentIndex > 0) { // maintain heap property
            int parentIndex = (currentIndex - 1) / 2;
            // swap if current is greater than its parent
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            if (current.compareTo(parent) > 0) {
                list.set(currentIndex, parent);
                list.set(parentIndex, current);
            } else
                break; // the tree is a heap
            currentIndex = parentIndex;
        }
    }

    public E remove() {
        if (list.size() == 0)
            return null;
        // copy the value of the last node to root
        E removedItem = list.get(0);
        list.set(0, list.get(list.size() - 1));
        // remove the last node from the heap
        list.remove(list.size() - 1);
        int currentIndex = 0;
        // ... continued ...
        while (currentIndex < list.size()) {
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;
            // find the maximum of the left and right nodes
            if (left >= list.size())
                break; // no left child
            int maxIndex = left;
            E max = list.get(maxIndex);
            if (right < list.size()) // right child exists
                if (max.compareTo(list.get(right)) < 0)
                    maxIndex = right;
            // swap if current is less than max
            E current = list.get(currentIndex);
            max = list.get(maxIndex);
            if (current.compareTo(max) < 0) {
                list.set(maxIndex, current);
                list.set(currentIndex, max);
                currentIndex = maxIndex;
            } else
                break; // the tree is a heap
        }
        return removedItem;
    }

    public static void main0(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.add(5);
        heap.add(1);
        heap.add(3);
        heap.add(7);
        heap.add(9);
        heap.add(0);
        System.out.println("Heap: " + heap.toString());
        System.out.println("Removed: " + heap.remove());
        System.out.println("Heap: " + heap.toString());
        System.out.println("Heap contains 7?: "
                + heap.contains(7));
    }

    public static void main1(String[] args) {
        Heap<String> heap = new Heap<>();
        heap.add("Kiwi");
        heap.add("Strawberry");
        heap.add("Apple");
        heap.add("Banana");
        heap.add("Orange");
        heap.add("Lemon");
        heap.add("Watermelon");
        System.out.println("Heap: " + heap.toString());
        System.out.println("Removed: " + heap.remove());
        System.out.println("Heap: " + heap.toString());
        System.out.println("Heap contains Pear?: "
                + heap.contains("Pear"));
    }

    public static void main2(String[] args) {
        Heap<String> heap = new Heap<>();
        heap.add("Apple");
        heap.add("Banana");
        heap.add("Kiwi");
        heap.add("Lemon");
        heap.add("Orange");
        heap.add("Strawberry");
        heap.add("Watermelon");
        System.out.println("Heap: " + heap.toString());
        System.out.println("Removed: " + heap.remove());
        System.out.println("Heap: " + heap.toString());
        System.out.println("Heap contains Pear?: "
                + heap.contains("Pear"));
    }

    public static void main(String[] args) {
        // System.out.println((int)'A');
        // System.out.println((int)'a');
        // System.out.println((int)'Z');
        // System.out.println((int)'z');
        // main0(args);
        // main1(args);
        main2(args);
    }

}

