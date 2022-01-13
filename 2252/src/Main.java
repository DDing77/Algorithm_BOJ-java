import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] indegree;
    static Deque<Integer> que = new LinkedList<>();
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static void solution() {
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) que.add(i);
        }
        while(!que.isEmpty()) {
            int x = que.poll();
            sb.append(x).append(' ');
            for(int y : arr[x]) {
                indegree[y]--;
                if(indegree[y] == 0) que.add(y);
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A].add(B);
            indegree[B]++;
        }
        solution();
    }
}
