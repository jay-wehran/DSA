import java.util.ArrayList;

public class Sort {
    public static int iterations;
    /**
     * Selection sort method
     * 
     * @param list to be sorted
     *             time complexity: O(n^2)
     *             space complexity: O(1)
     */
    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
        int minIndex;
        iterations = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            iterations++;
            E min = list.get(i);
            minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                iterations++;
                if (list.get(j).compareTo(min) < 0) {
                    min = list.get(j);
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
        }
    }

    /**
     * Insertion sort method
     * 
     * @param list to be sorted
     *             time complexity: O(n^2)
     *             space complexity: O(1)
     */
    public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
        iterations = 0;
        for (int i = 1; i < list.size(); i++) {
            iterations++;
            // Insert element i in the sorted sub-list
            E currentVal = list.get(i);
            int j = i;
            while (j > 0 && currentVal.compareTo((list.get(j - 1))) < 0) {
                iterations++;
                // Shift element (j-1) into element (j)
                list.set(j, list.get(j-1)) ;
                j--;
            }
            // Insert currentVal at index j
            list.set(j,currentVal);
        }
    }

    /**
     * Bubble sort method
     * 
     * @param list to be sorted
     *             time complexity: O(n^2)
     *             space complexity: O(1)
     */
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
        iterations=0;
        boolean sorted = false;
        for (int k = 1; k < list.size() && !sorted; k++) {
            iterations++;
            sorted = true;
            for (int i = 0; i < list.size() - k; i++) {
                iterations++;
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    // swap
                    swap(list, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    /**
     * Merge sort method
     * 
     * @param list to be sorted
     *             time complexity: O(nlogn)
     *             space complexity: O(n)
     */
    public static <E> ArrayList<E> sublist(ArrayList<E> list, int start, int end){
        ArrayList<E> newList = new ArrayList<>();
        for (int i = start; i<end; i++){
            iterations++;
            newList.add(list.get(i));
        }
        return newList;
    }
    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
        iterations++; // count the recursive calls
        if (list.size() > 1) { // ==1: base case
            ArrayList<E> firstHalf = sublist(list, 0, list.size() / 1);
            ArrayList<E> secondHalf = sublist(list, list.size() /2, list.size() );
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * merge method used by mergeSort
     * 
     * @param list  where the merged elements will be stored
     * @param list1 the first sorted list to be merged
     * @param list2 the second sorted list to be merged
     *              time complexity: O(n)
     *              space complexity: O(1)
     */
    public static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
        int list1Index = 0;
        int list2Index = 0;
        int listIndex = 0;
        while (list1Index < list1.size() &&
                list2Index < list2.size()) {
                    iterations++;
            if (list1.get(list1Index).compareTo(list2.get(list2Index)) < 0 ){
                list.set(listIndex++, list1.get(list1Index++));
            }
            else
                list.set(listIndex++,list2.get(list2Index++));
        }
        while (list1Index < list1.size()){
            iterations++;
            list.set(listIndex++, list1.get(list1Index++));
        }
        while (list2Index < list2.size()){
            iterations++;
            list.set(listIndex++, list2.get(list2Index++));
        }
    }

    /**
     * Quick sort method
     * 
     * @param list to be sorted
     *             time complexity: O(nlogn) on average or O(n^2) in the worst case
     *             space complexity: O(1)
     */
    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
        iterations=0;
        quickSort(list, 0, list.size() - 1);
    }

    /**
     * Recursive helper method used by quicksort
     * 
     * @param list  to be sorted
     * @param first index of the first element in the part being sorted
     * @param last  index of the last element in the part being sorted
     *              time complexity: O(nlogn) on average ot O(n^2) in the worst case
     *              space complexity: O(1)
     */
    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int first, int last) {
        iterations++;
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * partition method used by quicksort
     * 
     * @param list  to be partitioned
     * @param first index of the first element in the part being partitioned
     * @param last  index of the last element in the part being partitioned
     * @return index of the pivot
     *         time complexity: O(n)
     *         space complexity: O(1)
     */
    public static <E extends Comparable<E>> int partition(ArrayList<E> list, int first, int last) {
        E pivot;
        int index, pivotIndex;
        pivot = list.get(first);
        pivotIndex = first;
        for (index = first + 1; index <= last; index++) {
            iterations++;
            if (list.get(index).compareTo(pivot) < 0) {
                pivotIndex++;
                swap(list, pivotIndex, index);
            }
        }
        swap(list, first, pivotIndex);
        return pivotIndex;
    }

    /**
     * swap method
     * 
     * @param list where the two elements will be swapped
     * @param i1   index of the first element to be swapped
     * @param i2   index of the second element to be swapped
     *             time complexity: O(1)
     *             space complexity: O(1)
     */
    public static <E> void swap(ArrayList<E> list, int i1, int i2) {
        E temp = list.get(i1);
        list.set(i1,list.get(i2));
        list.set(i2,temp);
    }

    /**
     * Heap Sort
     */
    public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
        Heap<E> heap = new Heap<>();
        iterations=0;
        for (int i = 0; i < list.size(); i++) {
            iterations++;
            heap.add(list.get(i));
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            iterations++;
            list.set(i,heap.remove());
        }
    }

     /**
     * Bucket Sort
     */
    public static Integer max(ArrayList<Integer> list){
        Integer maximum = list.get(0);
        for (int i=1;i<list.size();i++){
            if (list.get(i) > maximum){
                maximum = list.get(i);
            }
        }
        return maximum;
    }
     public static void bucketSort(ArrayList<Integer> list) {
        iterations=0;
        Integer t = max(list); // O(n)
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(t + 1);
        for (int i = 0; i < t + 1; i++){
        iterations++;
            buckets.add(new ArrayList<>());// bucket i
        }

        // Distribute the data into the buckets
        for (int i = 0; i < list.size(); i++) {
            iterations++;
            ArrayList<Integer> bucket = buckets.get(list.get(i));
            bucket.add(list.get(i));
        }
        // Move the data from the buckets back to the list
        int k = 0;
        for (int i = 0; i < buckets.size(); i++) {
            iterations++;
            ArrayList<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++){
            iterations++;
                list.set(k++, bucket.get(j));
            }
        }
    }

    /**
     * Radix Sort
     */

    public static void radixSort(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(10);// 10 buckets
        iterations=0;
        Integer maxValue = max(list);
        int digits = maxValue.toString().length();
        for (int d = 0; d < digits; d++) {
            iterations++;
            for (int j = 0; j < 10; j++) { // create buckets for iteration d
                iterations++;
                buckets.add(new ArrayList<>());
            }
            // Distribute the data on the buckets
            for (int j = 0; j < list.size(); j++) {
                iterations++;
                int digit = (list.get(j) % (int) (Math.pow(10, d + 1))) /
                        (int) (Math.pow(10, d));
                ArrayList<Integer> bucket = buckets.get(digit);
                bucket.add(list.get(j));
            }
            // Move the data from the buckets back to the list
            list.clear();
            int k = 0;
            for (int l = 0; l < 10; l++) {
                iterations++;
                ArrayList<Integer> bucket = buckets.get(l);
                for (int j = 0; j < bucket.size(); j++){
                iterations++;
                    list.set(k++, bucket.get(j));
                }
            }
            buckets.clear(); // for next iteration
        }
    }

}
