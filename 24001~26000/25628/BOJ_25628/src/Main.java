import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(Math.min(Integer.parseInt(st.nextToken()) / 2, Integer.parseInt(st.nextToken())));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
