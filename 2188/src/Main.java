import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] room;
    static boolean[] isVisited;
    static ArrayList<Integer>[] cow;
    static int cnt = 0;

    static boolean DFS(int idx) {
        for(int next : cow[idx]) {
            if(isVisited[next]) continue;
            isVisited[next] = true;
            if(room[next] == 0 || DFS(room[next])){
                room[next] = idx;
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

        cow = new ArrayList[N + 1];
        room = new int[M + 1];

        for (int i = 1; i <= N; i++) cow[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            for (int j = 0; j < input; j++) cow[i].add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[M + 1];
            if (DFS(i)) cnt++;
        }

        System.out.println(cnt);
    }
}
