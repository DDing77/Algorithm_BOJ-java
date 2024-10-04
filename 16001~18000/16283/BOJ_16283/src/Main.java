import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int a;
    private int b;
    private int n;
    private int w;
    private int sheepCnt;
    private int goatCnt;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i * a + (n - i) * b == w) {
                count++;
                sheepCnt = i;
                goatCnt = n - i;
            }
        }

        if (count != 1) {
            System.out.println(-1);
        } else {
            System.out.println(sheepCnt + " " + goatCnt);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
