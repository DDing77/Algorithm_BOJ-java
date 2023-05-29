import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int res;

    static void up() {
        for (int i = 0; i < N; i++) {
            int putIdx = 0;
            int preVal = 0;
            for (int j = 0; j < N; j++) {
                if (map[j][i] != 0) {
                    if (preVal == map[j][i]) { // 합침
                        map[putIdx - 1][i] = preVal * 2;
                        res = Math.max(res, map[putIdx - 1][i]);
                        preVal = 0;
                        map[j][i] = 0;
                    } else { // 안합치고 올림
                        preVal = map[j][i];
                        map[j][i] = 0;
                        map[putIdx][i] = preVal;
                        putIdx++;
                    }
                }
            }
        }
    }

    static void down() {
        for (int i = 0; i < N; i++) {
            int putIdx = N - 1;
            int preVal = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    if (preVal == map[j][i]) {
                        map[putIdx + 1][i] = preVal * 2;
                        res = Math.max(res, map[putIdx + 1][i]);
                        preVal = 0;
                        map[j][i] = 0;
                    } else {
                        preVal = map[j][i];
                        map[j][i] = 0;
                        map[putIdx][i] = preVal;
                        putIdx--;
                    }
                }
            }
        }
    }

    static void left() {
        for (int i = 0; i < N; i++) {
            int putIdx = 0;
            int preVal = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    if (preVal == map[i][j]) {
                        map[i][putIdx - 1] = preVal * 2;
                        res = Math.max(res, map[i][putIdx - 1]);
                        preVal = 0;
                        map[i][j] = 0;
                    } else {
                        preVal = map[i][j];
                        map[i][j] = 0;
                        map[i][putIdx] = preVal;
                        putIdx++;
                    }
                }
            }
        }
    }

    static void right() {
        for (int i = 0; i < N; i++) {
            int putIdx = N - 1;
            int preVal = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    if (preVal == map[i][j]) {
                        map[i][putIdx + 1] = preVal * 2;
                        res = Math.max(res, map[i][putIdx + 1]);
                        preVal = 0;
                        map[i][j] = 0;
                    } else {
                        preVal = map[i][j];
                        map[i][j] = 0;
                        map[i][putIdx] = preVal;
                        putIdx--;
                    }
                }
            }
        }
    }

    static void move(int dir) {
        if (dir == 0) up();
        else if (dir == 1) down();
        else if (dir == 2) left();
        else right();
    }

    static void solution(int depth) {
        if (depth == 5) {
            return;
        }

        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) temp[i] = map[i].clone();

        for (int i = 0; i < 4; i++) {
            move(i);
            solution(depth + 1);
            for (int j = 0; j < N; j++) map[j] = temp[j].clone(); // rollback
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        res = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                res = Math.max(res, map[i][j]);
            }
        }

        solution(0);

        System.out.println(res);

    }
}