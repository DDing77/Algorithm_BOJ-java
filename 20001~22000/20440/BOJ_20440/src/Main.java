import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    int N;
    int[] prefixSum;
    int[][] coordinates;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        coordinates = new int[N][2];
        TreeSet<Integer> coordinateSet = new TreeSet<Integer>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            coordinates[i][0] = s;
            coordinates[i][1] = e;

            coordinateSet.add(s);
            coordinateSet.add(e);
        }

        ArrayList<Integer> idx = new ArrayList<>(coordinateSet);

        prefixSum = new int[idx.size()];
        for (int i = 0; i < N; i++) {
            int x = Collections.binarySearch(idx, coordinates[i][0]);
            int y = Collections.binarySearch(idx, coordinates[i][1]);
            for (int j = x; j < y; j++) {
                prefixSum[j]++;
            }
        }

        int max = 0;
        int maxStartIdx = -1;
        int maxEndIdx = -1;
        for (int i = 0; i < idx.size(); i++) {
            if (prefixSum[i] > max) {
                maxStartIdx = i;
                maxEndIdx = i;
                max = prefixSum[i];
            } else if (prefixSum[i] == max && i - 1 == maxEndIdx) {
                maxEndIdx = i;
            }
        }

        sb.append(max).append("\n");
        sb.append(idx.get(maxStartIdx)).append(" ").append(idx.get(maxEndIdx + 1));
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
