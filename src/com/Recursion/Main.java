package com.Recursion;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// merge sort with complexity of o(nlogn);.
        int[] arr = {6,4,9,2,1};
        System.out.println(Arrays.toString(mergesort(arr)));

    }
    public static int[] mergesort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergesort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);

    }
    public static int[] merge(int[] first,int[] second){
        int[] arrFinal = new int[first.length+ second.length];
        int i=0;
        int j=0;
        int k=0;

        while(i< first.length && j< second.length) {
            if (first[i] > second[j]) {
                arrFinal[k] = second[j];
                j++;
            }
            else {
                arrFinal[k] = first[i];
                i++;
            }
            k++;
        }
        // it may be possible that one of the array is not complete.
        // copy the remaining elements.
        while(i< first.length){
            arrFinal[k] = first[i];
            i++;
            k++;
        }
        while (j< second.length){
            arrFinal[k] = second[j];
            j++;
            k++;
        }
        return arrFinal;
    }
}
