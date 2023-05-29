import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;

    static int[] isSquare(int length) {
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        for (int i = 0; i <= N - length; i++) {
            for (int j = 0; j <= M - length; j++) {
                if (map[i][j] == map[i + length - 1][j] &&
                        map[i][j] == map[i][j + length - 1] &&
                        map[i][j] == map[i + length - 1][j + length - 1]) {
//                    System.out.println("length : " + length + " , " + map[i][j] + ", " + map[i + length - 1][j] + ", " + map[i][j + length - 1] + ", " + map[i + length - 1][j + length - 1]);
                    res[0] = 1;
                    res[1] = length * length;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int maxLength = N > M ? M : N;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
        }

        int size = 0;
        for (int i = 1; i <= maxLength; i++) {
            int[] temp = isSquare(i);
//            System.out.println(Arrays.toString(temp));
            if (temp[0] == 1) size = Math.max(size, temp[1]);
        }

        System.out.println(size);
    }
}