import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int A;
    private int B;
    private ArrayList<Integer> list;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 1; i <= B; i++) {
            if (list.size() <= B) {
                for (int j = 0; j < i; j++) {
                    list.add(i);
                }
            }
        }

        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
