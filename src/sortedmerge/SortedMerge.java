/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortedmerge;

/**
 *
 * @author wilsoncastiblanco
 */
public class SortedMerge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = new int[15];
        a[0] = 7;
        a[1] = 9;
        a[2] = 11;
        a[3] = 13;
        a[4] = 15;
        a[5] = 17;
        a[6] = 19;
        a[7] = 21;
        a[8] = 23;
        a[9] = 25;
        int[] b = new int[]{6, 8, 10, 12, 14};
        mergeSortedArrays(a, b);
    }

    public static void mergeSortedArrays(int[] a, int[] b) {
        int indexB = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = b[indexB];
                indexB++;
            }
        }
        mergeSort(a);
    }

    public static void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            sort(array, helper, middle, low, high);
        }
    }

    private static void sort(int[] array, int[] helper, int middle, int low, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }

        printResult(array);
    }

    private static void printResult(int[] array) {
        System.out.println("============================");
        for (int i = 0; i < array.length; i++) {
            System.out.println("" + array[i]);
        }
        System.out.println("============================");

    }

}
