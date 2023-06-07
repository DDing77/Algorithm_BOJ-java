import java.io.IOException;
import java.util.Arrays;

public class Main {

    static int[] num;

    public static int readInt() throws IOException {
        int n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws IOException {
        num = new int[3];
        num[0] = readInt();
        num[1] = readInt();
        num[2] = readInt();

        Arrays.sort(num);

        if (num[1] - num[0] == num[2] - num[1]) {
            System.out.println(num[2] + num[1] - num[0]);
        } else if (num[1] - num[0] < num[2] - num[1]) {
            System.out.println(num[1] + num[1] - num[0]);
        } else {
            System.out.println(num[0] + num[2] - num[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}