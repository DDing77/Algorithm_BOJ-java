import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    char[][] board;
    int[] parents;
    HashSet<Integer> set;
    int res;

    public int find(int x) {
        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (parents[a] < parents[b]) {
            parents[a] += parents[b];
            parents[b] = a;
        } else {
            parents[b] += parents[a];
            parents[a] = b;
        }
    }

    public int getNext(int x, int y) {
        int nX = x;
        int nY = y;

        if (board[x][y] == 'U') {
            nX--;
        } else if (board[x][y] == 'R') {
            nY++;
        } else if (board[x][y] == 'D') {
            nX++;
        } else {
            nY--;
        }

        return nX * M + nY;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        parents = new int[N * M];
        Arrays.fill(parents, -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                union(i * M + j, getNext(i, j));
            }
        }

        set = new HashSet<>();
        for (int i = 0; i < parents.length; i++) {
            if(parents[i] < 0) {
                set.add(i);
            }
        }

        System.out.println(set.size());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
