import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final int ARCHER_CNT = 3;
    int N;
    int M;
    int D;
    int[][] originMap;
    int[][] copyMap;
    ArrayList<Integer> archer;
    int res;

    public void comb(int start, int depth) {
        if (depth == ARCHER_CNT) {
            attack();
            return;
        }

        for (int i = start; i <= M; i++) {
            archer.add(i);
            comb(i + 1, depth + 1);
            archer.remove(archer.size() - 1);
        }
    }

    public void copy() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                copyMap[i][j] = originMap[i][j];
            }
        }
    }

    public int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public void attack() {
        copy();

        int cnt = 0;
        boolean[][] targeted;
        int minDistance;
        int minR;
        int minC;

        for (int i = 1; i <= N; i++) {
            targeted = new boolean[N + 1][M + 1];
            for (int j = 0; j < ARCHER_CNT; j++) {
                minDistance = Integer.MAX_VALUE;
                minR = Integer.MAX_VALUE;
                minC = Integer.MAX_VALUE;

                for (int k = 1; k <= N; k++) {
                    for (int l = 1; l <= M; l++) {
                        if (copyMap[k][l] == 1) {
                            int distance = getDistance(k, l, N + 1, archer.get(j));

                            if (minDistance == distance) {
                                if (minC > l) {
                                    minR = k;
                                    minC = l;
                                }
                            } else if (minDistance > distance) {
                                minDistance = distance;
                                minR = k;
                                minC = l;
                            }
                        }
                    }
                }

                if (D >= minDistance) {
                    targeted[minR][minC] = true;
                }
            }

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if (targeted[j][k]) {
                        cnt++;
                        copyMap[j][k] = 0;
                    }
                }
            }

            for (int j = N; j >= 1; j--) {
                for (int k = 1; k <= M; k++) {
                    copyMap[j][k] = copyMap[j - 1][k];
                }
            }
        }

        res = Math.max(res, cnt);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        originMap = new int[N + 1][M + 1];
        copyMap = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        archer = new ArrayList<>();
        comb(1, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
