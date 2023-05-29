package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int res = 1;
        for (int i = 1; i <= number; i++) {
            res *= i;
        }
        System.out.println(res);
    }
}
