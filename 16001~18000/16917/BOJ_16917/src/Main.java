import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int A;
    int B;
    int C;
    int X;
    int Y;

    private int calA(int A, int B) {
        int sum = 0;

        sum += A * X;
        sum += B * Y;

        return sum;
    }

    private int calB(int A, int B, int C, int X, int Y) {
        int sum = 0;
        if (X > Y) {
            sum += Y * (C * 2);
            sum += Math.min((X - Y) * A, (X - Y) * (C * 2));
        } else {
            sum += X * (C * 2);
            sum += Math.min((Y - X) * B, (Y - X) * (C * 2));
        }

        return sum;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int calA = calA(A, B);
        int calB = calB(A, B, C, X, Y);
        System.out.println(Math.min(calA, calB));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
