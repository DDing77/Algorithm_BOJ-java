package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        int standard = input.nextInt();
        int array[] = new int[num];

        for (int i = 0; i < num; i++) {
            int index = input.nextInt();
            array[i] = index;
        }
        for (int i = 0; i < num; i++) {
            if (array[i] < standard) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
