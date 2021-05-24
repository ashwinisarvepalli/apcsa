import java.util.*;

public class Sorts {
    private double steps; //keeps track of the number of steps

    public Sorts() {
        steps = 0;
    }

    public void bubbleSort(ArrayList<Comparable> list) { //comparable interface also used
        for (int outer = 0; outer < list.size() - 1; outer++) {
            for (int inner = 0; inner < list.size() - outer - 1; inner++) {
                steps += 3; 
                if (list.get(inner).compareTo(list.get(inner + 1)) > 0) {
                    steps += 4;
                    Comparable temp = list.get(inner);
                    list.set(inner, list.get(inner + 1));
                    list.set(inner + 1, temp);
                }
            }
        }
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();
    }
    
    public void insertionSort(ArrayList<Comparable> list) { //comparable interface also used
        for (int outer = 1; outer < list.size(); outer++) {
            int pos = outer;
            Comparable key = list.get(pos);
            steps += 4;
            while (pos > 0 && list.get(pos - 1).compareTo(key) > 0) {
                steps += 4;
                list.set(pos, list.get(pos - 1));
                pos--;
            }
            list.set(pos, key);
        }
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();
    }

    /**
     * Takes in unsorted list, and merges the following sections together:
     * Left sublist from a[first]..a[mid], right sublist from a[mid+1]..a[last].
     * each sublist is already in ascending order
     * 
     * a - reference to an array of integers to be sorted
     * first - starting index of range of values to be sorted
     * mid - midpoint index of range of values to be sorted
     * last - last index of range of values to be sorted
     */
    // helper method for mergesort
    private void merge(ArrayList<Comparable> a, int first, int mid, int last) { //comparable interface also used
        int f = first;
        int m = mid + 1;
        int l = last;
        ArrayList<Comparable> temp = new ArrayList<Comparable>();

        while ((f <= mid) && (m <= last)) {
            steps += 3;
            if (a.get(f).compareTo(a.get(m)) <= 0) {
                steps++;
                temp.add(a.get(f));
                f++;
            } else {
                steps++;
                temp.add(a.get(m));
                m++;
            }
        }

        while (f <= mid) {
            steps++;
            temp.add(a.get(f));
            f++;
        }

        while (m <= last) {
            steps++;
            temp.add(a.get(m));
            m++;
        }

        int j = first;
        for (int i = 0; i < temp.size(); i++) {
            steps += 2;
            a.set(j, temp.get(i));
            j++;
        }

    }

    /** 
     * a - reference to an array of integers to be sorted
     * first - starting index of range of values to be sorted
     * last - ending index of range of values to be sorted
     */
    public void mergeSort(ArrayList<Comparable> a, int first, int last) { //comparable interface also used
        if (first < last && (last - first) >= 1) {
            int mid = (last + first) / 2;
            mergeSort(a, first, mid);
            mergeSort(a, mid + 1, last);
            merge(a, first, mid, last);
        }

    }

    /**
     * a - reference to an array of integers to be sorted
     * first - starting index of range of values to be sorted
     * last - ending index of range of values to be sorted
     */
    public void quickSort(ArrayList<Comparable> a, int first, int last) {//comparable interface also used
        if (first < last) {
            int f = first;
            int l = last;
            Comparable pivot = a.get((first + last)/2);
            steps++;
            int pivotindex = first + (last - first) / 2;
            while (f < l) {
                steps += 2;
                while (a.get(f).compareTo(pivot) < 0) {
                    f++;
                }
                steps += 2;
                while (a.get(l).compareTo(pivot) > 0) {
                    l--;
                }
                if (f <= l) {
                    swap(a, f, l);
                    f++;
                    l--;
                }
            }
            if (first < l) {
                quickSort(a, first, l);
            }
            if (f < last) {
                quickSort(a, f, last);
            }
        }
    }

    /**
     * Accessor method to return the current value of steps
     */
    public double getStepCount() {
        return steps;
    }

    /**
     * Modifier method to set or reset the step count. Usually called prior to
     * invocation of a sort method.
     * 
     * stepCount - value assigned to steps
     */
    public void setStepCount(long stepCount) {
        steps = stepCount;
    }

    /**
     * Interchanges two elements in an ArrayList
     * 
     * list - reference to an array of integers
     * a - index of integer to be swapped
     * b - index of integer to be swapped
     */
    //helper method for quicksort
    public void swap(ArrayList<Comparable> list, int a, int b) { 
        steps += 3;
        Comparable temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}