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
                /* copying sorted elements into list */
                i++;
                k++;
            } else {
                list.set(k, rightList.get(j));
                j++;
                k++;
            }
            mergeCount++;
        }

        /* copying remaining elements into list */
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

    double maxVal1(double A[], int n) {
        double max = A[0];
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

    double maxVal2(double A[], int init, int end) {
        maxVal2Count++;
        if (end - init <= 1) {
            return Math.max(A[init], A[end]);
        } else {
            int m = (init + end) / 2;
            double v1 = maxVal2(A, init, m);
            double v2 = maxVal2(A, m + 1, end);
            return Math.max(v1, v2);
        }
    }

    public int getmaxVal2Count() {
        return maxVal2Count;
    }

    public long muliply(long x, long y, int n) {
        if (n == 1) {
            return x * y;
        }

        int m = (int) Math.ceil(n / 2.0);
        long a = (long) ((x) / Math.pow(2.0, m));
        long b = (long) ((x) % Math.pow(2.0, m));
        long c = (long) ((y) / Math.pow(2.0, m));
        long d = (long) ((y) % Math.pow(2.0, m));

        long e = muliply(a, c, m);
        long f = muliply(b, d, m);
        long g = muliply(b, c, m);
        long h = muliply(a, d, m);

        return (long) ((Math.pow(2, 2 * m) * e) + (Math.pow(2, m) * (g + h) + f));
    }

    // MULTIPLY(x, y, n)
    // IF (n = 1)
    // RETURN x * y.
    // ELSE
    // m ← ⎡ n / 2 ⎤.
    // a ← ⎣ x / 2^m ⎦; b ← x mod 2^m.
    // c ← ⎣ y / 2^m ⎦; d ← y mod 2^m.
    // e ← MULTIPLY(a, c, m).
    // f ← MULTIPLY(b, d, m).
    // g ← MULTIPLY(b, c, m).
    // h ← MULTIPLY(a, d, m).
    // RETURN 2^(2m)*e + 2^m*(g + h) + f.

    public long multiplyString(String x, String y) {

        int n = Math.max(x.length(), y.length());

        x = padLeft(x, n);
        y = padLeft(y, n);

        return multiply(x, y, n);

    }

    private String padLeft(String str, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length(); i < length; i++) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    private long multiply(String x, String y, int n) {

        if (n == 1) {
            return Long.parseLong(String.valueOf(x.charAt(0)), 2) * Long.parseLong(String.valueOf(y.charAt(0)), 2);

        }
            int m = (int) Math.ceil(n / 2.0);
            String X1 = x.substring(0, m);
            String X0 = x.substring(m);
            String Y1 = y.substring(0, m);
            String Y0 = y.substring(m);

            long e = multiply(X1, Y1, m);
            long f = multiply(X0, Y0, m);
            long g = multiply(X0, Y1, m);
            long h = multiply(X1, Y0, m);

            return (long) ((Math.pow(2, 2 * m) * e) + (Math.pow(2, m) * (g + h) + f));

        

    }

}
