import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static final int LENGTH = 4;
    static int T;
    static int[][] coordinates;

    public static double getDistance(int[] o1, int[] o2) {
        return Math.sqrt(Math.pow(o1[0] - o2[0], 2) + Math.pow(o1[1] - o2[1], 2));
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            coordinates = new int[LENGTH][2];
            for (int i = 0; i < LENGTH; i++) {
                st = new StringTokenizer(br.readLine());
                coordinates[i][0] = Integer.parseInt(st.nextToken());
                coordinates[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(coordinates, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
            });

            double baseDistance = getDistance(coordinates[0], coordinates[1]);
            if (baseDistance == getDistance(coordinates[0], coordinates[2])
                    && baseDistance == getDistance(coordinates[3], coordinates[1])
                    && baseDistance == getDistance(coordinates[3], coordinates[2])
                    && getDistance(coordinates[0], coordinates[3]) == getDistance(coordinates[1], coordinates[2])) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
