package br.pucrs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        App app = new App();

        System.out.println("Hello World!");
        List<Integer> array = new ArrayList();
        for (int i = 0; i < 10; i++) {
            array.add((int) Math.round((Math.random() * 100)));
        }
        for (Integer number : array) {
            System.out.println(number);
        }

        System.out.println("\n");
        List<Integer> sortedArray = app.mergeSort(array);
        for (Integer number : sortedArray) {
            System.out.println(number);
        }

        System.out.println("\n\n");
        System.out.println(app.getMergeCount());

        long x = 15;
        long y = 15;
        System.out.println(app.muliply(x, y, 2));


    }
}
