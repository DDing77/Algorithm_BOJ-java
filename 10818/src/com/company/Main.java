package com.company;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        sort(array);
        System.out.print(array[0] + " ");
        System.out.println(array[n - 1]);
    }
}
