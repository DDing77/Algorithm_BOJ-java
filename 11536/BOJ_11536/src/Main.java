import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final String[] message = {
            "INCREASING",
            "DECREASING",
            "NEITHER"
    };
    static int N;
    static String[] input, sorted;
    static int value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        value = 0;
        for (int i = 0; i < N - 1; i++) {
            value += input[i].compareTo(input[i + 1]) < 0 ? -1 : 1;
        }

        if (value == 1 - N) {
            System.out.println(message[0]);
        } else if (value == N - 1) {
            System.out.println(message[1]);
        } else {
            System.out.println(message[2]);
        }
    }
}
