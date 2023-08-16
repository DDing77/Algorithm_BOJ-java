import java.util.*;
import java.io.*;

public class Main {

    int N;
    int P;
    int[] isVisited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        isVisited = new int[1001];
        int cur = N;
        int cnt = 1;

        while (isVisited[cur] == 0) {
            isVisited[cur] = cnt++;
            cur = cur * N % P;
        }

        System.out.println(cnt - isVisited[cur]);
    }

    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
}