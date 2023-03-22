import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*author : DDing77*/

public class Main {

    private int P;
    private int tCase;
    private ArrayList<Integer> line;
    private int res;

    public int lowerBound(ArrayList<Integer> line, int target) {
        int left = 0;
        int right = line.size();
        int mid;

        while (left < right) {
            mid = left + right >> 1;
            if (line.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            tCase = Integer.parseInt(st.nextToken());

            res = 0;
            line = new ArrayList<>();
            while (st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());

                if (line.isEmpty() || line.get(line.size() - 1) < cur) {
                    line.add(cur);
                    continue;
                }

                int targetIdx = lowerBound(line, cur);

                res += (line.size() - targetIdx);
                line.add(targetIdx, cur);
            }

            sb.append(tCase).append(" ").append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
