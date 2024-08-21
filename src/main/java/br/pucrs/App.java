package br.pucrs;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    int mergeCount = 0;
    int maxVal1Count = 0;
    int maxVal2Count = 0;

    public List<Integer> mergeSort(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        }

        List<Integer> leftList = new ArrayList<>(list.subList(0, list.size() / 2));
        leftList = mergeSort(leftList);

        List<Integer> rightList = new ArrayList<>(list.subList(list.size() / 2, list.size()));
        rightList = mergeSort(rightList);

        return merge(list, leftList, rightList);
    }

    public List<Integer> merge(List<Integer> list, List<Integer> leftList, List<Integer> rightList) {
        int i = 0, j = 0, k = 0;

        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) < rightList.get(j)) {
                list.set(k, leftList.get(i));
                /*copying sorted elements into list*/
                i++;
                k++;
            } else {
                list.set(k, rightList.get(j));
                j++;
                k++;
            }
            mergeCount++;
        }

        /*copying remaining elements into list*/
        while (i < leftList.size()) {
            list.set(k, leftList.get(i));
            i++;
            k++;
            mergeCount++;
        }

        while (j < rightList.size()) {
            list.set(k, rightList.get(j));
            j++;
            k++;
            mergeCount++;
        }
        return list;
    }

    public int getMergeCount() {
        return mergeCount;
    }

    long maxVal1(long A[], int n) {
        long max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            maxVal1Count++;
        }
        return max;
    }

    public int getmaxVal1Count() {
        return maxVal1Count;
    }

    long maxVal2(long A[], int init, int end) {
        maxVal2Count++;
        if (end - init <= 1) {
            return Math.max(A[init], A[end]);
        } else {
            int m = (init + end) / 2;
            long v1 = maxVal2(A, init, m);
            long v2 = maxVal2(A, m + 1, end);
            return Math.max(v1, v2);
        }
    }

    public int getmaxVal2Count() {
        return maxVal2Count;
    }
}
