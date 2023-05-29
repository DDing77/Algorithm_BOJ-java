package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	while(true){
	    int a = input.nextInt();
	    int b = input.nextInt();
	    if(a == 0 && b == 0)
	        break;
	    System.out.println(a + b);
    }
    }
}
