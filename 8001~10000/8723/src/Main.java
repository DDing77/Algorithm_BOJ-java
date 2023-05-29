import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        adj = new int[3];
        for (int i = 0; i < 3; i++) {
            adj[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(adj);

        if (adj[0] == adj[1] && adj[1] == adj[2] && adj[0] == adj[2]) System.out.println(2);
        else if (adj[2] * adj[2] == adj[0] * adj[0] + adj[1] * adj[1]) System.out.println(1);
        else System.out.println(0);
    }
}