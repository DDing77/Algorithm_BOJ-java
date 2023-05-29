import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        int res = 0;
        int size = 1;
        int num = 10;

        for (int i = 1; i <= N; i++) {
            if (i % num == 0) {
                size++;
                num *= 10;
            }
            res += size;
        }

        System.out.println(res);
    }
}