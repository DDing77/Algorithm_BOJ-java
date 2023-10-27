import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String jinho;
    int N;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        jinho = br.readLine();
        N = Integer.parseInt(br.readLine());

        res = 0;
        while (N-- > 0) {
            if (jinho.equals(br.readLine())) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
