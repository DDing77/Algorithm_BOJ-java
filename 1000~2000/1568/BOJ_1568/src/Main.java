import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        res = 0;
        int val = 1;
        while (N > 0) {
            N -= val++;
            if (val > N) {
                val = 1;
            }
            res++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}

