package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCase = input.nextInt();
        int avg;

        for (int i = 0; i < testCase; i++) {
            int length = input.nextInt();
            int score[] = new int[length];
            int sum = 0;
            int count = 0;
            for (int j = 0; j < length; j++) {
                score[j] = input.nextInt();
                sum += score[j];
            }
            avg = sum / length;
            for (int k = 0; k < length; k++) {
                if (score[k] > avg) {
                    count += 1;
                }
            }
            System.out.println(String.format("%.3f",((double) count / (double) length * 100)) + "%");
        }

    }
}
