import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    static final String Message1 = "Messi";
    static final String Message2 = "Messi Gimossi";

    int N;
    int[] dp;

    private int getDpSize(int N) {

        int first = 5;
        int second = 13;
        int cur = 18;
        int size = 2;

        while (true) {
            cur = second + first + 1;
            first = second;
            second = cur;
            size++;
            if (cur >= N) {
                break;
            }
        }

        return size;
    }

    private void makeDpTable(int size) {

        dp = new int[size + 1];
        dp[1] = 5;
        dp[2] = 13;
        for (int i = 3; i <= size; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + 1;
        }
    }

    private char recur(int N, int dpIdx) {
        if (N <= 13) {
            return Message2.charAt(N - 1);
        }

        if (N <= dp[dpIdx - 1]) {
            return recur(N, dpIdx - 1);
        } else if (N == dp[dpIdx - 1] + 1) {
            return ' ';
        } else {
            int newN = N - (dp[dpIdx - 1] + 1);
            return recur(newN, dpIdx - 2);
        }
    }

    private void print(char ch) {
        if (ch == ' ') {
            System.out.println("Messi Messi Gimossi");
        } else {
            System.out.println(ch);
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N <= 13) {
            print(Message2.charAt(N - 1));
            return;
        }

        int size = getDpSize(N);
        makeDpTable(size);

        print(recur(N, size));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
