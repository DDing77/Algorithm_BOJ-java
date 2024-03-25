import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int A;
    int B;

    private void solution() throws IOException {

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());

        System.out.println(Integer.compare(A, B));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
