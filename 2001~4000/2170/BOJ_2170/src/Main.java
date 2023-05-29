import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Line implements Comparable<Line> {
        int left;
        int right;

        public Line(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int compareTo(Line o) {
            if (this.left == o.left) return this.right - o.right;
            return this.left - o.left;
        }
    }

    static Line[] lines;
    static int N;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        lines = new Line[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            lines[i] = new Line(left, right);
        }

        Arrays.sort(lines);

        int left = lines[0].left;
        int right = lines[0].right;
        res = Math.abs(right - left);

        for (int i = 1; i < N; i++) {
            if (right >= lines[i].right) continue;

            if (right >= lines[i].left) {
                res += Math.abs(lines[i].right - right);
                right = lines[i].right;
            }

            if (right < lines[i].left) {
                res += Math.abs(lines[i].right - lines[i].left);
                left = lines[i].left;
                right = lines[i].right;
            }
        }
        System.out.println(res);
    }
}
