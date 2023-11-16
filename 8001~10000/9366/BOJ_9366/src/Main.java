import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int T;
    int[] edges;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            edges = new int[3];
            st = new StringTokenizer(br.readLine());
            edges[0] = Integer.parseInt(st.nextToken());
            edges[1] = Integer.parseInt(st.nextToken());
            edges[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(edges);

            sb.append("Case #").append(tc).append(": ");
            if (edges[0] + edges[1] <= edges[2]) {
                sb.append("invalid!");
            } else if (edges[0] == edges[1] && edges[1] == edges[2]) {
                sb.append("equilateral");
            } else if (edges[0] == edges[1] || edges[1] == edges[2] || edges[0] == edges[2]) {
                sb.append("isosceles");
            } else {
                sb.append("scalene");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
