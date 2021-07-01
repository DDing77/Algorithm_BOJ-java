import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        int split1 = b % 10;
        int split2 = (b % 100) / 10;
        int split3 = b / 100;
        int result = (a * split1) + (a * split2 * 10) + (a * split3 * 100);

        System.out.println(a * split1);
        System.out.println(a * split2);
        System.out.println(a * split3);
        System.out.print(result);
    }
}
