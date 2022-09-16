import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int tc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            sb.append("yes").append('\n');
        }
        System.out.print(sb);
    }
}