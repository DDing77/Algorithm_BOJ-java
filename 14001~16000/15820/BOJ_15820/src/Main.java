import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int sampleTest;
    int systemTest;

    private boolean check(int size) throws IOException {
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());

            if (!st.nextToken().equals(st.nextToken())) {
                return false;
            }
        }
        return true;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        sampleTest = Integer.parseInt(st.nextToken());
        systemTest = Integer.parseInt(st.nextToken());

        if (!check(sampleTest)) {
            System.out.println("Wrong Answer");
        } else if (!check(systemTest)) {
            System.out.println("Why Wrong!!!");
        } else {
            System.out.println("Accepted");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}

