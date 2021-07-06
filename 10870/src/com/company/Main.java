package com.company;
import java.util.Scanner;
public class Main {
    static int Fib(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        return Fib(number - 1) + Fib(number - 2);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        System.out.println(Fib(number));
    }
}
