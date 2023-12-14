import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    double[] edges;
    double left;
    double right;

    public void solution() {
        left = 0.0;
        for (int i = 0; i < 57; i++) {
            double mid = (left + right) / 2;
            long cnt = 1;
            for (int j = 0; j < edges.length; j++) {
                cnt *= (long) (edges[j] / mid);
            }
            if (cnt >= N) {
                if (left == mid) break;
                left = mid;
            } else {
                if (right == mid) break;
                right = mid;
            }
        }
        System.out.println(left);
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        edges = new double[3];
        right = Double.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            edges[i] = Double.parseDouble(st.nextToken());
            right = Math.min(right, edges[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
