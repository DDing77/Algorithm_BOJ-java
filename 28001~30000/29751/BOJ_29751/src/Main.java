import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    double w;
    double h;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Double.parseDouble(st.nextToken());
        h = Double.parseDouble(st.nextToken());

        System.out.printf("%.1f", w * h / 2);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
