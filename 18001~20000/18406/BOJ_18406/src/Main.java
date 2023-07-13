import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String score;

    public static int getSum(int idx, int size) {
        int sum = 0;

        for (int i = idx; i < idx + size; i++) {
            sum += score.charAt(i) - '0';
        }

        return sum;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        score = br.readLine();

        int size = score.length() / 2;
        if (getSum(0, size) == getSum(size, size)) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
