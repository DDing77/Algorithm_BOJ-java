package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int dec[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        int res = a * b * c;
        int number;
        while (true) {
            number = res % 10;
            res /= 10;
            dec[number] += 1;
            if (res == 0)
                break;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(dec[i]);
        }
    }
}
