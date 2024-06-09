import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private long res;
    
    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        res = 1L;

        for (int i = 2; i <= N; i++) {
            res += i / 6 + 1;

            if(i % 6 == 1) {
                res--;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
