import java.io.*;
import java.util.*;
public class Main {
static class info {
    int from;
    int to;
    int time;

    public info(int from, int to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }
}

    static int N, M;
    static info [] List;
    static long [] Cost;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Cost = new long [N + 1];
        List = new info [M + 1];
        for(int i = 1 ; i<= N ; i++) {
            Cost[i] = INF;
        }

        int A, B, C;
        for(int i = 1 ; i <= M ;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            List[i] = new info(A, B, C);
        }

        findShortestPath(1);
        boolean isNegativeCycle = findNegativeCycle();

        if(isNegativeCycle == true) {
            bw.write("-1" + "\n");
            bw.flush();
            bw.close();
            return;
        }

        for(int i = 2 ; i<= N ; i++) {
            if(Cost[i] == INF) {
                bw.write("-1" + "\n");
            } else {
                bw.write(Cost[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void findShortestPath(int start) {
        Cost[start] = 0;

        for(int i = 1 ; i <= N - 1 ; i++) {
            for(int j = 1 ; j <= M ; j++) {
                info nowEdge = List[j];
                if(Cost[nowEdge.from] != INF) {
                    if(Cost[nowEdge.to] > Cost[nowEdge.from] + nowEdge.time) {
                        Cost[nowEdge.to] = Cost[nowEdge.from] + nowEdge.time;
                    }
                }
            }
        }
    }

    private static boolean findNegativeCycle() {
        for(int j = 1 ; j <= M ; j++) {
            info nowEdge = List[j];
            if(Cost[nowEdge.from] != INF) {
                if(Cost[nowEdge.to] > Cost[nowEdge.from] + nowEdge.time) {
                    return true;
                }
            }
        }

        return false;
    }
}