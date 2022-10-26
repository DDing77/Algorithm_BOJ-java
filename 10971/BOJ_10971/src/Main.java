import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int [][] DP;
    static int [][] W ;
    static int VisitAll;
    static final int Inf = Integer.MAX_VALUE;
    static int Answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        VisitAll = (1 << N) - 1;
        W = new int [N+1][N+1];
        DP = new int [N+1][VisitAll + 1];

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Answer = Inf;
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 0 ; j <= VisitAll ; j++) {
                DP[i][j] = Inf;
            }
        }

        DP[1][1] = 0;
        getDP(1, 1);

        bw.write(Answer + "\n");
        bw.flush();
        bw.close();
    }

    private static void getDP(int now, int visited) {
        if(visited == VisitAll) {
            if(W [now][1] == 0) {
                return;
            }
            Answer = Math.min(Answer, DP[now][visited] + W[now][1]);
        }

        for(int i = 1 ; i <= N ; i++) {
            int next = (1<<(i-1));
            int nextVisited =  visited | next;
            if(nextVisited == visited) {
                continue;
            }
            if(W[now][i] == 0) {
                continue;
            }

            if(DP[i][nextVisited] > DP[now][visited] + W[now][i]) {
                DP[i][nextVisited] = DP[now][visited] + W[now][i];
                getDP(i, nextVisited);
            }
        }
    }
}