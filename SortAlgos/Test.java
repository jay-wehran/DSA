import java.util.Collections;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        final int SIZE = 10000;
        // Dataset 1: random list
        ArrayList<Integer> randomList = new ArrayList<>(SIZE);
        for (int i=0;i<SIZE;i++){
            randomList.add((int)(Math.random() * SIZE));
        }
        // Dataset 2: sorted list
        ArrayList<Integer> sortedList = (ArrayList<Integer>) (randomList.clone());
        Collections.sort(sortedList);

        // Dataset 3: reversed list
        ArrayList<Integer> reversedList = (ArrayList<Integer>) (sortedList.clone());
        Collections.reverse(reversedList);

        Sort.selectionSort(randomList);
        System.out.printf("%-20s\t%-10d\t","Selection Sort", Sort.iterations);
        Sort.selectionSort(sortedList);
        System.out.printf("%-10d\t",Sort.iterations);
        Sort.selectionSort(reversedList);
        System.out.printf("%-10d\n",Sort.iterations);

        Collections.shuffle(randomList);
        Collections.shuffle(reversedList);

        //Insertion Sort
        Sort.insertionSort(randomList);
        System.out.printf("%-20s\t%-10d\t","Insertion Sort", Sort.iterations);
        Sort.insertionSort(sortedList);
        System.out.printf("%-10d\t",Sort.iterations);
        Sort.insertionSort(reversedList);
        System.out.printf("%-10d\n",Sort.iterations);

        Collections.shuffle(randomList);
        Collections.shuffle(reversedList);

        // Bubble Sort
        Sort.bubbleSort(randomList);
        System.out.printf("%-20s\t%-10d\t","Bubble Sort", Sort.iterations);
        Sort.bubbleSort(sortedList);
        System.out.printf("%-10d\t",Sort.iterations);
        Sort.bubbleSort(reversedList);
        System.out.printf("%-10d\n",Sort.iterations);

        Collections.shuffle(randomList);
        Collections.shuffle(reversedList);
        // Merge Sort
        Sort.iterations=0;
        Sort.mergeSort(randomList);
        System.out.printf("%-20s\t%-10d\t","Merge Sort", Sort.iterations);
        Sort.iterations=0;
        Sort.mergeSort(sortedList);
        System.out.printf("%-10d\t",Sort.iterations);
        Sort.iterations=0;
        Sort.mergeSort(reversedList);
        System.out.printf("%-10d\n",Sort.iterations);


        Collections.shuffle(randomList);
        Collections.shuffle(reversedList);

        // Quick Sort
        Sort.quickSort(randomList);
        System.out.printf("%-20s\t%-10d\t","Quick Sort", Sort.iterations);
        Sort.quickSort(sortedList);
        System.out.printf("%-10d\t",Sort.iterations);
        Sort.quickSort(reversedList);
        System.out.printf("%-10d\n",Sort.iterations);

        Collections.shuffle(randomList);
        Collections.shuffle(reversedList);

        // Heap Sort
        Sort.heapSort(randomList);
        System.out.printf("%-20s\t%-10d\t","Heap Sort", Sort.iterations);
        Sort.heapSort(sortedList);
        System.out.printf("%-10d\t",Sort.iterations);
        Sort.heapSort(reversedList);
        System.out.printf("%-10d\n",Sort.iterations);

        Collections.shuffle(randomList);
        Collections.shuffle(reversedList);

        // Bucket Sort
        Sort.bucketSort(randomList);
        System.out.printf("%-20s\t%-10d\t","Bucket Sort", Sort.iterations);
        Sort.bucketSort(sortedList);
        System.out.printf("%-10d\t",Sort.iterations);
        Sort.bucketSort(reversedList);
        System.out.printf("%-10d\n",Sort.iterations);

        Collections.shuffle(randomList);
        Collections.shuffle(reversedList);

        // Radix Sort
        Sort.radixSort(randomList);
        System.out.printf("%-20s\t%-10d\t","Radix Sort", Sort.iterations);
        Sort.radixSort(sortedList);
        System.out.printf("%-10d\t",Sort.iterations);
        Sort.radixSort(reversedList);
        System.out.printf("%-10d\n",Sort.iterations);
    }

    
}
