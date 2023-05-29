import java.io.*;

public class Main { // BOJ_1463
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        System.out.println(operator(X, 0));
    }

    static int operator(int X, int count) {
        if (X < 2) return count;
        return Math.min(operator(X / 2, count + 1 + (X % 2)), operator(X / 3, count + 1 + (X % 3)));
    }
}
