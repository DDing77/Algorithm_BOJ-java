package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();

        if (A > 0 && A < 10 && B > 0 && B < 10) {
            System.out.println(A - B);
        }
    }
}
