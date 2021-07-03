package com.company;

import java.util.Scanner;

public class Main {
    public static int temp1;
    public static int temp2;
    public static int temp3;
    public static int newNumber;

    public static int newNum(int num) {
        int initNumber = num;
        if (num >= 10) {
            temp1 = initNumber / 10;
            temp2 = initNumber % 10;
            newNumber = (temp1 + temp2) % 10 + temp2 * 10;
        } else {
            temp3 = (initNumber * 10 + initNumber);
            newNumber = temp3;
        }
        return newNumber;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int count = 0;
        int temp4 = number;
        while (true) {
            count++;
            int res = newNum(temp4);
            temp4 = res;
            if (res == number) {
                break;
            }
        }
        System.out.println(count);
    }
}
