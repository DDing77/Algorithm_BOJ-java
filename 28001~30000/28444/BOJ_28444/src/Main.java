import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int res = 0;
        st = new StringTokenizer(br.readLine());

        res = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        res -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
