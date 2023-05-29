import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] people;
    static int[] notebook;
    static boolean[] isVisited;
    static int cnt = 0;

    static boolean DFS(int now) {
        for(int next : people[now]) {
            if(isVisited[next]) continue;
            isVisited[next] = true;
            if( notebook[next] == 0 || DFS(notebook[next])) {
                notebook[next] = now;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        people = new ArrayList[N+1];
        notebook = new int[N+1];

        for(int i=0; i<=N; i++) people[i] = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            people[a].add(b);
        }

        for(int i=1; i<=N; i++) {
            isVisited = new boolean[N+1];
            if(DFS(i)) cnt++;
        }

        System.out.println(cnt);
    }
}

