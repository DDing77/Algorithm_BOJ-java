import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hour = input.nextInt();
        int min = input.nextInt();

        int toSecond = hour * 60 + min;
        if (toSecond - 45 > 0) {
            System.out.print((toSecond - 45) / 60 + " ");
            System.out.println((toSecond - 45) % 60);
        } else if (toSecond - 45 < 0) {
            System.out.print(((24 * 60 + min) - 45) / 60 + " ");
            System.out.println(((24 * 60 + min) - 45) % 60);
        } else {
            System.out.println("0 0");
        }
    }
}
