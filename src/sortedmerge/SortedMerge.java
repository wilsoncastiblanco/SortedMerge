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
        mergeSortedArrays(a, b, 10, b.length);
    }

    private static void mergeSortedArrays(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastB + lastA - 1;
        
        while(indexB >= 0){
            if(indexA >= 0 && a[indexA] > b[indexB]){
                a[indexMerged] = a[indexA];
                indexA--;
            }else{
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
        
        printResult(a);
    }


    private static void printResult(int[] array) {
        System.out.println("============================");
        for (int i = 0; i < array.length; i++) {
            System.out.println("" + array[i]);
        }
        System.out.println("============================");

    }

}
