import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] num;
    static int[] tree;

    public static int init(int start, int end, int nodeNum) {
        if (start == end) {
            return tree[nodeNum] = num[start];
        }

        return tree[nodeNum] = init(start, (start + end) >> 1, nodeNum << 1)
                * init(((start + end) >> 1) + 1, end, (nodeNum << 1) + 1);
    }

    public static int update(int start, int end, int target, int val, int nodeNum) {
        if (target < start || end < target) {
            return tree[nodeNum];
        }

        if (start == end) {
            return tree[nodeNum] = val;
        }

        return tree[nodeNum] = tree[nodeNum] = update(start, (start + end) >> 1, target, val, nodeNum << 1)
                * update(((start + end) >> 1) + 1, end, target, val, (nodeNum << 1) + 1);
    }

    public static int getValue(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryLeft > end || queryRight < start) {
            return 1;
        }

        if (queryLeft <= start && end <= queryRight) {
            return tree[nodeNum];
        }

        return getValue(start, (start + end) >> 1, queryLeft, queryRight, nodeNum << 1)
                * getValue(((start + end) >> 1) + 1, end, queryLeft, queryRight, nodeNum << 1 + 1);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            num = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                num[i] = Integer.parseInt(st.nextToken());

                if (num[i] > 0) {
                    num[i] = 1;
                }

                if (num[i] < 0) {
                    num[i] = -1;
                }
            }

            int size = 1;
            while (size < N) {
                size *= 2;
            }
            size *= 2;

            tree = new int[size + 1];

            init(1, N, 1);

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (op == 'C') {
                    if (b > 0) {
                        b = 1;
                    }

                    if (b < 0) {
                        b = -1;
                    }

                    update(1, N, a, b, 1);
                }

                if (op == 'P') {
                    int val = getValue(1, N, a, b, 1);

                    if (val == 0) {
                        sb.append("0");
                    }

                    if (val > 0) {
                        sb.append("+");
                    }

                    if (val < 0) {
                        sb.append("-");
                    }
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
