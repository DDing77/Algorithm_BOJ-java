package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        String str;
        for(int j =0; j < testCase; j++){
            str = input.next();
            int scoreStack = 0;
            int total = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'O') {
                    scoreStack ++;
                    total += scoreStack;
                } else scoreStack = 0;
            }
            System.out.println(total);
        }
    }
}
