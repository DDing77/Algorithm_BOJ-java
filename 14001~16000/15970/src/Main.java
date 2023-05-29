import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, sum;
    static ArrayList<Integer>[] a;
    static int coord, color;

    static int toLeft(int color, int idx) {
        if (idx == 0) return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if (idx + 1 == a[color].size()) return Integer.MAX_VALUE;
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    static void getSum() {
        for (int color = 1; color <= N; color++) {
            Collections.sort(a[color]);
        }
        sum = 0;
        for (int color = 1; color <= N; color++) {
            for (int i = 0; i < a[color].size(); i++) {
                int leftDistance = toLeft(color, i);
                int rightDistance = toRight(color,i);
                sum+= Math.min(leftDistance,rightDistance);
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        a = new ArrayList[N + 1];
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            coord = Integer.parseInt(st.nextToken());
            color = Integer.parseInt(st.nextToken());
            a[color].add(coord);
        }
        getSum();
    }
}
