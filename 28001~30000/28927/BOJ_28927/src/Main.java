import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    int max;
    int mel;

    private void solution() throws IOException {
        max = getSum();
        mel = getSum();

        if (max > mel) {
            System.out.println("Max");
        } else if (max < mel) {
            System.out.println("Mel");
        } else {
            System.out.println("Draw");
        }
    }

    private int getSum() throws IOException {
        int sum;
        st = new StringTokenizer(br.readLine());
        sum = Integer.parseInt(st.nextToken()) * 3;
        sum += Integer.parseInt(st.nextToken()) * 20;
        sum += Integer.parseInt(st.nextToken()) * 120;

        return sum;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
